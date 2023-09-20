package com.saif.driversroute.data.source.remote

import com.saif.driversroute.data.api.ApiService
import com.saif.driversroute.data.model.DriverRouteResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: ApiService,
    private val ioDispatcher: CoroutineDispatcher
): RemoteDataSource {

    override suspend fun getDriversRoutes(): DriverRouteResponse {
        return service.getDriversRoutes()
    }
}