package com.example.myprofilecompose.ui.navigationdrawer.presenter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myprofilecompose.R
import com.example.myprofilecompose.data.model.MenuItem
import com.example.myprofilecompose.ui.theme.gradientBrush

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(brush = gradientBrush)
            .padding(vertical = 14.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 20.dp, end = 16.dp) // Padding de 20 dp al inicio y 16 dp al final
        ) {
            // Imagen de perfil
            Image(
                painter = painterResource(id = R.drawable.img_perfil), // Usa tu imagen aquí
                contentDescription = "Imagen de perfil",
                modifier = Modifier
                    .size(60.dp) // Tamaño de la imagen más pequeña
                    .clip(CircleShape) // Para hacer la imagen circular
                    .border(2.dp, Color.Black, CircleShape) // Borde alrededor de la imagen
            )

            Spacer(modifier = Modifier.width(16.dp)) // Espacio entre la imagen y los textos

            // Columna con los textos
            Column {
                Text(
                    text = "Desarrollador Android",
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = "Ricardo Soto",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }
    }
}



@Composable
fun DrawerBody(
    items: List<MenuItem>,
    onItemClick: (MenuItem) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        items.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(item) }
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.title
                )
            }
        }
    }
}