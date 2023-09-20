package com.saif.driversroute.data.source.local

import com.saif.driversroute.data.db.drivers.DriverEntity
import com.saif.driversroute.data.db.routes.RouteEntity

interface LocalDataSource {

    suspend fun getDrivers(): List<DriverEntity>

    suspend fun getRoutes(): List<RouteEntity>

    suspend fun addDriver(driverEntity: DriverEntity)

    suspend fun addRoute(routeEntity: RouteEntity)
}