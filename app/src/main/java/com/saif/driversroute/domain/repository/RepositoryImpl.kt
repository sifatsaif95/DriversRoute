package com.saif.driversroute.domain.repository

import com.saif.driversroute.data.db.drivers.DriverEntity
import com.saif.driversroute.data.db.routes.RouteEntity
import com.saif.driversroute.data.source.local.LocalDataSource
import com.saif.driversroute.data.source.remote.RemoteDataSource
import com.saif.driversroute.domain.model.DriversRoutesEntity
import com.saif.driversroute.domain.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val IODispatcher: CoroutineDispatcher
) : Repository {

    override suspend fun getDriversRoutes(): Flow<Result<DriversRoutesEntity>> = callbackFlow{
        val drivers = localDataSource.getDrivers()
        val routes = localDataSource.getRoutes()
        if (drivers.isEmpty() || routes.isEmpty()) {
            try {
                remoteDataSource.getDriversRoutes().run {
                    this.routes.forEach {
                        localDataSource.addRoute(
                            RouteEntity(
                                id = it.id,
                                name = it.name,
                                type = it.type
                            )
                        )
                    }
                    this.drivers.forEach {
                        localDataSource.addDriver(
                            DriverEntity(
                                id = it.id,
                                name = it.name
                            )
                        )
                    }
                }
                trySend(Result.Success(DriversRoutesEntity(localDataSource.getDrivers(), localDataSource.getRoutes())))
            } catch (e: Exception) {
                trySend(Result.Error(e.message ?: "Unknown error"))
            }

        } else {
            trySend(Result.Success(DriversRoutesEntity(drivers, routes)))
        }

        awaitClose {

        }
    }.flowOn(IODispatcher)
}