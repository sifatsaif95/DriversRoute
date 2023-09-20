package com.saif.driversroute.di

import android.content.Context
import androidx.room.Room
import com.saif.driversroute.data.api.ApiService
import com.saif.driversroute.data.api.RetrofitBuilder
import com.saif.driversroute.data.db.RoomDatabase
import com.saif.driversroute.data.db.drivers.DriversDAO
import com.saif.driversroute.data.db.routes.RoutesDAO
import com.saif.driversroute.data.source.local.LocalDataSource
import com.saif.driversroute.data.source.local.LocalDataSourceImpl
import com.saif.driversroute.data.source.remote.RemoteDataSource
import com.saif.driversroute.data.source.remote.RemoteDataSourceImpl
import com.saif.driversroute.domain.repository.Repository
import com.saif.driversroute.domain.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideService() =
        RetrofitBuilder().getRetrofit().create(ApiService::class.java)

    @Provides
    fun provideRoomDatabaseInstance(@ApplicationContext context: Context) = Room.databaseBuilder(context, RoomDatabase::class.java, "RoomDatabase").build()

    @Provides
    fun provideRoutesDao(database: RoomDatabase) = database.routesDao()

    @Provides
    fun provideDriversDao(database: RoomDatabase) = database.driversDao()

    @Provides
    fun provideLocalDataSource(driversDAO: DriversDAO, routesDAO: RoutesDAO): LocalDataSource =
        LocalDataSourceImpl(driversDAO, routesDAO)

    @Provides
    fun provideRemoteDataSource(service: ApiService, ioDispatcher: CoroutineDispatcher): RemoteDataSource =
        RemoteDataSourceImpl(service, ioDispatcher)

    @Provides
    fun provideRepository(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource, ioDispatcher: CoroutineDispatcher): Repository =
        RepositoryImpl(localDataSource, remoteDataSource, ioDispatcher)

    @Provides
    fun provideIODispatcher() = Dispatchers.IO
}