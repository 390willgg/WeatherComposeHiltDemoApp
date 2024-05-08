package com.example.weathercomposedemoapp.presentation.view.main.forecast

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercomposedemoapp.R
import com.example.weathercomposedemoapp.ui.theme.WeatherComposeDemoAppTheme

@Preview(showBackground = true)
@Composable
fun ForecastItemPreview() {
    WeatherComposeDemoAppTheme {
        ForecastItem(modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun ForecastDayItemPreview() {
    WeatherComposeDemoAppTheme {
        ForecastDayItem(modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherForecastHourlyPreview() {
    WeatherComposeDemoAppTheme {
        WeatherForecastHourly(modifier = Modifier)
    }
}

@Composable
fun WeatherForecastHourly(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White.copy(alpha = 0.8f))
            .padding(12.dp)
    ) {
        LazyColumn {
            item {
                LazyRow {
                    items(10) {
                        ForecastItem(modifier = modifier)
                    }
                }
                HorizontalDivider()
            }
            items(10) {
                ForecastDayItem(modifier = modifier)
            }
        }
    }
}

@Composable
fun ForecastItem(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .width(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Title", textAlign = TextAlign.Center, modifier = modifier.fillMaxWidth()
        )

        Text(
            text = "12:00",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )

        Image(
            painter = painterResource(id = R.drawable.sunny_icon),
            contentDescription = "Weather Icon",
            modifier = modifier
                .size(45.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "28°C", textAlign = TextAlign.Center, modifier = modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ForecastDayItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Wed",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = modifier.weight(1f)
        )

        Image(
            painter = painterResource(id = R.drawable.sunny_icon),
            contentDescription = "Weather Icon",
            modifier = modifier
                .size(45.dp)
                .weight(2f)
        )

        Text(
            text = "29°C/30°C",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = modifier.weight(1f)
        )
    }
}

