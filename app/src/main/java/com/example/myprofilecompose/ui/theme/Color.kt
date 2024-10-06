package com.example.myprofilecompose.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


//special
val gradientBrush = Brush.verticalGradient(
    colors = listOf(
        Color(0x801E88E5),
        Color(0x80FFFFFF)
    )
)
val gradientButtonMetallic = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFB0BEC5), // Gris claro
        Color(0xFF90A4AE), // Gris medio
        Color(0xFFCFD8DC), // Plateado claro
        Color(0xFF000000), // Gris más oscuro
        Color(0xFFECEFF1)  // Blanco/gris para reflejo
    )
)
val gradientButtonBlue = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF0870C2),
        Color(0xFF64B5F6)
    )
)