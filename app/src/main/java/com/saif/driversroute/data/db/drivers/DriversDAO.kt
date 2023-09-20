package com.saif.driversroute.data.db.drivers

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DriversDAO {

    @Query("SELECT * FROM table_drivers")
    fun getDrivers(): List< DriverEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDriver(driverEntity: DriverEntity)
}