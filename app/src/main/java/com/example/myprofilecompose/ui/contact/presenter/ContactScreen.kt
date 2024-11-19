package com.example.myprofilecompose.ui.contact.presenter

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myprofilecompose.R
@Preview(showBackground = true)
@Composable
fun ContactScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.img_contact),
            contentDescription = "image contact",
            modifier = Modifier
                .padding(top = 40.dp)
                .size(250.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Como contactarme:",
            fontSize = 26.sp,
        )
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_whatsapp),
                contentDescription = "WhatsApp icon",
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "+569 5646 8732")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_gmail),
                contentDescription = "Email icon",
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified

            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "ricardosr4@gmail.com")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_linkedin),
                contentDescription = "LinkedIn icon",
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "linkedin.com/in/ricardosotoramirez")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_instagram),
                contentDescription = "Instagram icon",
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "@ramirezricardosoto")
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            onClick = { sendEmail(context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .height(45.dp),
        ) {
            Text(
                text = stringResource(R.string.enviar_email)
            )
        }
    }
}
fun sendEmail(context: Context) {
    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:jeannette.smm87@gmail.com") // Combina `mailto:` con el correo
        putExtra(Intent.EXTRA_SUBJECT, "Consulta desde mi aplicación")
        putExtra(Intent.EXTRA_TEXT, "Hola Ricardo, quisiera contactarme contigo.")
    }

    try {
        context.startActivity(Intent.createChooser(emailIntent, "Elige un cliente de correo"))
    } catch (e: Exception) {
        // Manejo en caso de que no haya una aplicación compatible
        e.printStackTrace()
    }
}


