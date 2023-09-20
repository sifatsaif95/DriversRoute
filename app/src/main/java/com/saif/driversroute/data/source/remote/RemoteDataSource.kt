package com.saif.driversroute.data.source.remote

import com.saif.driversroute.data.model.DriverRouteResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getDriversRoutes(): DriverRouteResponse
}