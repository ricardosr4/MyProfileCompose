package com.example.myprofilecompose.ui.contact.presenter

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myprofilecompose.R
import com.example.myprofilecompose.ui.theme.ButtonBlue
import com.example.myprofilecompose.ui.theme.Purple40

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
            contentDescription = null,
            modifier = Modifier
                .padding(top = 40.dp)
                .size(250.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.contact_me),
            fontSize = 26.sp)

        Spacer(modifier = Modifier.height(30.dp))

        ContactRow(
            iconId = R.drawable.icon_whatsapp,
            text = stringResource(id = R.string.whatsapp_number)
        )
        ContactRow(
            iconId = R.drawable.icon_gmail,
            text = stringResource(id = R.string.my_gmail)
        )
        ContactRow(
            iconId = R.drawable.icon_linkedin,
            text = stringResource(id = R.string.my_linkedin)
        )
        ContactRow(
            iconId = R.drawable.icon_instagram,
            text = stringResource(id = R.string.my_instagram)
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            onClick = { sendEmail(context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple40,
                contentColor = Color.White
            )
        ) {
            Text(text = stringResource(R.string.enviar_email))
        }
    }
}

@Composable
fun ContactRow(iconId: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(vertical = 14.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = text)
    }
}

fun sendEmail(context: Context) {
    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:jeannette.smm87@gmail.com")
        putExtra(Intent.EXTRA_SUBJECT, "Consulta desde mi aplicación")
        putExtra(Intent.EXTRA_TEXT, "Hola Ricardo, quisiera contactarme contigo.")
    }
    try {
        context.startActivity(Intent.createChooser(emailIntent, "Elige un cliente de correo"))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
