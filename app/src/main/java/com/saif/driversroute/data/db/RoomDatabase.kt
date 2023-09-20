package com.saif.driversroute.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saif.driversroute.data.db.drivers.DriverEntity
import com.saif.driversroute.data.db.drivers.DriversDAO
import com.saif.driversroute.data.db.routes.RouteEntity
import com.saif.driversroute.data.db.routes.RoutesDAO

@Database(
    entities = [RouteEntity::class, DriverEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RoomDatabase: RoomDatabase() {
    abstract fun driversDao(): DriversDAO
    abstract fun routesDao(): RoutesDAO
}