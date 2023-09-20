package com.saif.driversroute.data.db.routes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_routes")
data class RouteEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String
)