package com.saif.driversroute.data.db.routes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoutesDAO {

    @Query("SELECT * FROM table_routes")
    fun getRoutes(): List<RouteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoute(routeEntity: RouteEntity)

}