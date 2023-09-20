package com.saif.driversroute.ui.drivers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saif.driversroute.data.db.drivers.DriverEntity
import com.saif.driversroute.data.model.Driver
import com.saif.driversroute.ui.theme.DriversRouteTheme

@Composable
fun DriverListItem(
    modifier: Modifier = Modifier,
    driver: DriverEntity
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = driver.name)
    }
}


@Preview(showBackground = true)
@Composable
fun DriverListItemPreview() {
    DriversRouteTheme {
        DriverListItem(driver = DriverEntity("1", "Zahid Hossain"))
    }
}