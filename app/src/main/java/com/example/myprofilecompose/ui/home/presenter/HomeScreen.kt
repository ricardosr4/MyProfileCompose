package com.example.myprofilecompose.ui.home.presenter

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myprofilecompose.R
import com.example.myprofilecompose.navigation.AppScreen

@Composable
fun HomeScreen(navController: NavController, onTitleChange: (String) -> Unit) {
    val context = LocalContext.current


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.img_port_home),
                contentDescription = "imagen portada",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 10.dp,
                            bottomEnd = 10.dp
                        )
                    )
            )

            Row(
                modifier = Modifier
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = {
                    val intent =
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ricardosr4"))
                    context.startActivity(intent)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icons_github),
                        contentDescription = "Github",
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))

                Image(
                    painter = painterResource(id = R.drawable.img_perfil),
                    contentDescription = "image profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(170.dp)
                        .clip(CircleShape)
                        .border(width = 3.dp, color = Color.Black, shape = CircleShape)
                )

                Spacer(modifier = Modifier.width(20.dp))

                IconButton(onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/ricardosotoramirez/")
                    )
                    context.startActivity(intent)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_linkedin),
                        contentDescription = "linkedin",
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp),
                        tint = Color.Unspecified
                    )
                }
            }

            Text(
                text = stringResource(R.string.profile_description),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 30.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.roboto_light)),
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    IconButton(onClick = {
                        onTitleChange("Sobre mí")
                        navController.navigate(AppScreen.AboutMeScreen.route)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_about_me),
                            contentDescription = "Ir a pantalla 1",
                            modifier = Modifier.size(60.dp),
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        text = "Sobre mí",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    IconButton(onClick = {
                        onTitleChange("Mis proyectos")
                        navController.navigate(AppScreen.ProjectScreen.route)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_project),
                            contentDescription = "Ir a pantalla 2",
                            modifier = Modifier.size(60.dp),
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        text = "Proyectos",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    IconButton(onClick = {
                        onTitleChange("Herramientas")
                        navController.navigate(AppScreen.TechnologiesScreen.route)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_build),
                            contentDescription = "Ir a pantalla 3",
                            modifier = Modifier.size(60.dp),
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        text = "Herramientas",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }

        }
    }
}

