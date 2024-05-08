package com.example.weathercomposedemoapp.presentation.view.main.weatherShortInformatio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercomposedemoapp.R
import com.example.weathercomposedemoapp.presentation.view.main.DarkLightModePreviews
import com.example.weathercomposedemoapp.presentation.view.main.FontScalePreviews
import com.example.weathercomposedemoapp.ui.theme.WeatherComposeDemoAppTheme

@FontScalePreviews
@DarkLightModePreviews
@Composable
fun WeatherScreenComponentPreview() {
    WeatherComposeDemoAppTheme {
        WeatherComponentInformation(modifier = Modifier)
    }
}

@Composable
fun WeatherComponentInformation(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .height(160.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = modifier
                .background(Color.White.copy(alpha = 0.8f))
                .padding(bottom = 8.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                modifier = modifier
                    .height(60.dp)
                    .padding(4.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(
                    id = R.drawable.precipitation_icon
                ),
                contentDescription = "Rain Precipitation Icon",
                alignment = Alignment.Center
            )
            Text(
                text = "0.0 ~ 1 hour",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
            Text(
                text = "Precipitation Rain Text",
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth()
            )
        }
    }
}
