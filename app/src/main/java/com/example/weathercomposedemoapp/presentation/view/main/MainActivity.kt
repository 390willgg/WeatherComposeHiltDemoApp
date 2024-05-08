package com.example.weathercomposedemoapp.presentation.view.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercomposedemoapp.presentation.ApiProviderOptions
import com.example.weathercomposedemoapp.presentation.view.main.currentTemperatureInformation.CurrentTemperatureComponentInformation
import com.example.weathercomposedemoapp.presentation.view.main.forecast.WeatherForecastHourly
import com.example.weathercomposedemoapp.presentation.view.main.weatherCurrentStatus.WeatherCurrentStatus
import com.example.weathercomposedemoapp.presentation.view.main.weatherShortInformatio.WeatherComponentInformation
import com.example.weathercomposedemoapp.ui.theme.WeatherComposeDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeatherScreenPreview() {
    WeatherComposeDemoAppTheme {
        WeatherScreen()
    }
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var weatherViewModelFactory: WeatherViewModel.Factory
    private val weatherViewModel: WeatherViewModel by viewModels {
        WeatherViewModel.provideFactory(
            weatherViewModelFactory, ApiProviderOptions.OPEN_WEATHER
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherComposeDemoAppTheme {
                weatherViewModel.getCurrentWeather(35.0, 139.0, "metric")
                weatherViewModel.currentWeather.observe(this) { response ->
                    Log.d("Response", response.toString())
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun WeatherScreen(modifier: Modifier = Modifier) {
    Box{
        Card(
            modifier = modifier
                .padding(
                    top = 12.dp, end = 12.dp
                )
                .width(32.dp)
                .height(32.dp)
                .align(Alignment.TopEnd),
            shape = RoundedCornerShape(50.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            IconButton(
                modifier = modifier.padding(8.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add City Weather Area",
                )
            }
        }

        Text(
            text = "Pemangkat",
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp),
            textAlign = TextAlign.Center
        )

        Column(
            modifier = modifier
                .align(Alignment.TopCenter)
                .padding(top = 36.dp)
        ) {
            WeatherCurrentStatus(modifier)

            CurrentTemperatureComponentInformation(modifier)

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                WeatherComponentInformation(
                    modifier = modifier.weight(0.333f)
                )
                WeatherComponentInformation(
                    modifier = modifier.weight(0.333f)
                )
                WeatherComponentInformation(
                    modifier = modifier.weight(0.333f)
                )
            }
            WeatherForecastHourly(modifier = modifier)
        }
    }
}


