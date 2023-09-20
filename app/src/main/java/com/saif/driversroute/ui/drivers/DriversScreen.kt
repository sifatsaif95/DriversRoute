package com.saif.driversroute.ui.drivers

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.saif.driversroute.utils.Utils.observeAsState

@Composable
fun DriversScreen(
    viewModel: DriversScreenViewModel = hiltViewModel()
) {

    val data = viewModel.data.collectAsState()

    val lifecycleState = LocalLifecycleOwner.current.lifecycle.observeAsState()
    when(lifecycleState.value) {
        Lifecycle.Event.ON_RESUME -> {
            viewModel.getData()
        }
        else -> {}
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(data.value.drivers){
            DriverListItem(driver = it)
        }
    }
}