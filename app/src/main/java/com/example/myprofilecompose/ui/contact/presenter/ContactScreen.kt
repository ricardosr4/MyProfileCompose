package com.example.myprofilecompose.ui.contact.presenter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myprofilecompose.R

@Preview(showBackground = true)
@Composable
fun ContactScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen centrada
        Image(
            painter = painterResource(id = R.drawable.img_contact),
            contentDescription = "image contact",
            modifier = Modifier
                .padding(top = 40.dp)
                .size(250.dp)
        )

        // Espacio de 20dp
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Como contactarme:",
            fontSize = 26.sp,
            )
        Spacer(modifier = Modifier.height(50.dp))

        // Primera fila: WhatsApp
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_whatsapp), // Cambia al ID correcto del ícono
                contentDescription = "WhatsApp icon",
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified

            )
            Spacer(modifier = Modifier.width(8.dp)) // Espacio entre ícono y texto
            Text(text = "+569 5646 8732") // Número de contacto
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Segunda fila: Email
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_gmail), // Cambia al ID correcto del ícono
                contentDescription = "Email icon",
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified

            )
            Spacer(modifier = Modifier.width(8.dp)) // Espacio entre ícono y texto
            Text(text = "ricardosr4@gmail.com") // Dirección de correo
        }
        Spacer(modifier = Modifier.height(20.dp))


        // Tercera fila: LinkedIn
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_linkedin), // Cambia al ID correcto del ícono
                contentDescription = "LinkedIn icon",
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified

            )
            Spacer(modifier = Modifier.width(8.dp)) // Espacio entre ícono y texto
            Text(text = "linkedin.com/in/ricardosotoramirez") // Enlace a LinkedIn
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_instagram), // Cambia al ID correcto del ícono
                contentDescription = "Instagram icon",
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified

            )
            Spacer(modifier = Modifier.width(8.dp)) // Espacio entre ícono y texto
            Text(text = "@ramirezricardosoto") // Enlace a LinkedIn
        }
    }


}

//Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(text = "Contacto",
//            fontSize = 32.sp)
//
//    }