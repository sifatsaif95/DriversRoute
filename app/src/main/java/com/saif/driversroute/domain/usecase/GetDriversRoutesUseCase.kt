package com.saif.driversroute.domain.usecase

import com.saif.driversroute.domain.model.DriversRoutesEntity
import com.saif.driversroute.domain.model.Result
import com.saif.driversroute.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetDriversRoutesUseCase @Inject constructor(
    private val repository: Repository,
    private val IODispatcher: CoroutineDispatcher
) {
    suspend fun execute(): Flow<Result<DriversRoutesEntity>> =
        repository.getDriversRoutes()
}