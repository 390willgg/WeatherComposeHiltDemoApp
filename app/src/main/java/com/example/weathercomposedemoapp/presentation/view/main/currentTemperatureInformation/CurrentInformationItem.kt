package com.example.weathercomposedemoapp.presentation.view.main.currentTemperatureInformation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercomposedemoapp.R
import com.example.weathercomposedemoapp.presentation.view.main.DarkLightModePreviews
import com.example.weathercomposedemoapp.presentation.view.main.FontScalePreviews

@FontScalePreviews
@DarkLightModePreviews
@Composable
fun CurrentTemperatureComponentInformationPreview() {
    CurrentTemperatureComponentInformation(modifier = Modifier)
}

@Composable
fun CurrentTemperatureComponentInformation(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.sunny_day_icon),
            contentDescription = "Sunny Day",
            modifier = Modifier.weight(1f)
        )

        Column(
            modifier = modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = "28°C",
                fontSize = 64.sp,
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth()
            )

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Max Temp")
                Text("31°C")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "27°C")
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Min Temp")
            }
        }
    }
}