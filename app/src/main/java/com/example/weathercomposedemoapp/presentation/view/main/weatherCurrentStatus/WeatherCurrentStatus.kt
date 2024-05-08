package com.example.weathercomposedemoapp.presentation.view.main.weatherCurrentStatus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weathercomposedemoapp.presentation.view.main.DarkLightModePreviews
import com.example.weathercomposedemoapp.presentation.view.main.FontScalePreviews

@FontScalePreviews
@DarkLightModePreviews
@Composable
fun WeatherCurrentStatusPreview() {
    WeatherCurrentStatus(modifier = Modifier)
}

@Composable
fun WeatherCurrentStatus(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Raining", style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = "Raining More", style = MaterialTheme.typography.bodySmall
        )
    }
}
