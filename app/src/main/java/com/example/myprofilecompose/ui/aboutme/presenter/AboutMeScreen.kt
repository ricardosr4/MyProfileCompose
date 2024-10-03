package com.example.myprofilecompose.ui.aboutme.presenter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myprofilecompose.R
import com.example.myprofilecompose.ui.theme.gradientBrush
import com.example.myprofilecompose.ui.theme.gradientButtonBlue
import com.example.myprofilecompose.ui.theme.gradientButtonMetallic

@Preview(showBackground = true)
@Composable
fun AboutMeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                painter = painterResource(id = R.drawable.img_cv_example),
                contentDescription = "imagen cv",
                
                )

        }
        Button(
            onClick = { /* Acción */ },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent, // Usamos Color.Transparent ya que manejamos el fondo con Brush
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(20.dp)
                .width(300.dp)
                .background(brush = gradientButtonMetallic, shape = RoundedCornerShape(20.dp))
                .border(
                    width = 4.dp,
                    brush = gradientButtonMetallic,
                    shape = RoundedCornerShape(20.dp)
                )
                .align(Alignment.BottomCenter)
                .background(
                    brush = gradientButtonBlue,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Text(
                text = "Descargar Cv",
                style = TextStyle(
                    fontSize = 20.sp,
                    shadow = Shadow(
                        color = Color.Gray, // Sombra del texto
                        blurRadius = 3f
                    )
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}
