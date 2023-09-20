package com.saif.driversroute.domain.repository

import com.saif.driversroute.domain.model.DriversRoutesEntity
import com.saif.driversroute.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getDriversRoutes(): Flow<Result<DriversRoutesEntity>>
}