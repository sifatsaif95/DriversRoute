package com.saif.driversroute.data.source.local

import com.saif.driversroute.data.db.drivers.DriverEntity
import com.saif.driversroute.data.db.drivers.DriversDAO
import com.saif.driversroute.data.db.routes.RouteEntity
import com.saif.driversroute.data.db.routes.RoutesDAO
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val driversDAO: DriversDAO,
    private val routesDAO: RoutesDAO
) : LocalDataSource {
    override suspend fun getDrivers(): List<DriverEntity> =
        driversDAO.getDrivers()

    override suspend fun getRoutes(): List<RouteEntity> =
        routesDAO.getRoutes()

    override suspend fun addDriver(driverEntity: DriverEntity) {
        driversDAO.insertDriver(driverEntity)
    }

    override suspend fun addRoute(routeEntity: RouteEntity) {
        routesDAO.insertRoute(routeEntity)
    }
}