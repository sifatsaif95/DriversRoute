package com.saif.driversroute.ui.drivers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saif.driversroute.domain.model.DriversRoutesEntity
import com.saif.driversroute.domain.model.Result
import com.saif.driversroute.domain.usecase.GetDriversRoutesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriversScreenViewModel @Inject constructor(
    private val getDriversRoutesUseCase: GetDriversRoutesUseCase
): ViewModel() {

    private val _data: MutableStateFlow<DriversRoutesEntity> = MutableStateFlow(
        DriversRoutesEntity(
            mutableListOf(), mutableListOf()
        )
    )
    val data: StateFlow<DriversRoutesEntity> = _data

    private val _error: MutableStateFlow<String> = MutableStateFlow("")
    val error: StateFlow<String> = _error

    fun getData() {
        viewModelScope.launch {
            getDriversRoutesUseCase.execute().collectLatest { result->
                when(result) {
                    is Result.Success -> _data.value = result.data
                    is Result.Error -> _error.value = result.error
                }
            }
        }
    }
}