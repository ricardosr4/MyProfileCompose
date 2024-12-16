package com.example.myprofilecompose.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val SkyBlue = Color(0xFF03A9F4)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val ButtonBlue = Color(0xFF00097C)

// Primarios
val PrimaryColor = Color(0xFF6200EA) // Violeta intenso
val PrimaryVariant = Color(0xFF3700B3) // Violeta oscuro

// Secundarios
val SecondaryColor = Color(0xFF03DAC5) // Verde aguamarina
val SecondaryVariant = Color(0xFF018786) // Verde aguamarina oscuro

// Fondos
val BackgroundColorLight = Color(0xFFF5F5F5) // Gris claro
val BackgroundColorDark = Color(0xFF121212) // Negro suave
val SurfaceColorLight = Color(0xFFFFFFFF) // Blanco puro
val SurfaceColorDark = Color(0xFF1E1E1E) // Gris oscuro

// Textos y Contrastes
val TextPrimary = Color(0xFF000000) // Negro
val TextSecondary = Color(0xFF757575) // Gris intermedio
val TextOnPrimary = Color(0xFFFFFFFF) // Blanco sobre primario
val TextError = Color(0xFFD32F2F) // Rojo

// Colores de Alerta
val ErrorColor = Color(0xFFB00020) // Rojo oscuro
val WarningColor = Color(0xFFFFA000) // Ámbar
val SuccessColor = Color(0xFF4CAF50) // Verde

// Tonos Creativos
val CreativePink = Color(0xFFE91E63) // Rosa vibrante
val CreativeBlue = Color(0xFF2196F3) // Azul brillante
val CreativeOrange = Color(0xFFFF5722) // Naranja intenso
val CreativeYellow = Color(0xFFFFEB3B) // Amarillo brillante

// Tonos Pastel
val PastelMint = Color(0xFFB2DFDB) // Menta suave
val PastelPeach = Color(0xFFFFCCBC) // Durazno
val PastelLavender = Color(0xFFD1C4E9) // Lavanda
val PastelBlue = Color(0xFFBBDEFB) // Azul cielo

// Extras
val NeutralGray = Color(0xFF9E9E9E) // Gris neutral
val LightGreen = Color(0xFF8BC34A) // Verde claro
val LightPurple = Color(0xFFAB47BC) // Morado claro
val DeepBlue = Color(0xFF303F9F) // Azul profundo
val DeepOrange = Color(0xFFF4511E) // Naranja oscuro


//special

val gradientBrush = Brush.verticalGradient(
    colors = listOf(
        Color(0x80001CD5),
        Color(0x80FFFFFF)
    )
)
val gradientButtonMetallic = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFB0BEC5),
        Color(0xFF90A4AE),
        Color(0xFFCFD8DC),
        Color(0xFF000000),
        Color(0xFFECEFF1)
    )

)
val gmailGradientButton = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFEA4335), // Rojo
        Color(0xFFFBBC05), // Amarillo
        Color(0xFF34A853), // Verde
        Color(0xFF4285F4)  // Azul
    )

)

