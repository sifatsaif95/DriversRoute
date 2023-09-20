package com.saif.driversroute.domain.model

import com.saif.driversroute.data.db.drivers.DriverEntity
import com.saif.driversroute.data.db.routes.RouteEntity

data class DriversRoutesEntity(
    val drivers: List<DriverEntity>,
    val routes: List<RouteEntity>
)
