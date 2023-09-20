package com.saif.driversroute.data.api

import com.saif.driversroute.data.model.DriverRouteResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/data")
    suspend fun getDriversRoutes(): DriverRouteResponse
}