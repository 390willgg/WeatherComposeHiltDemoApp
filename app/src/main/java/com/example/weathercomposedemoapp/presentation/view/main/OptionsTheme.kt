package com.example.weathercomposedemoapp.presentation.view.main

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Small font",
    group = "Font Scale",
    fontScale = 0.5f
)

@Preview(
    name = "Large font",
    group = "Font Scale",
    fontScale = 1.5f
)

annotation class FontScalePreviews

@Preview(
    name = "Light Mode",
    group = "UI Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true
)

@Preview(
    name = "Dark Mode",
    group = "UI Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true
)
annotation class DarkLightModePreviews
