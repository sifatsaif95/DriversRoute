package com.saif.driversroute.data.db.drivers

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_drivers")
data class DriverEntity(
    @PrimaryKey val id: String,
    val name: String

)
