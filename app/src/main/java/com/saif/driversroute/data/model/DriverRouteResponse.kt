package com.saif.driversroute.data.model

data class DriverRouteResponse(
    val drivers: List<Driver>,
    val routes: List<Route>
)