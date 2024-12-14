package com.example.myprofilecompose.ui.contact.presenter

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myprofilecompose.R
import com.example.myprofilecompose.ui.contact.state.ContactState
import com.example.myprofilecompose.ui.contact.viewModel.ContactViewModel
import com.example.myprofilecompose.ui.theme.Purple40

@Composable
fun ContactScreen(viewModel: ContactViewModel = viewModel()) {

    val context = LocalContext.current
    val contactState by viewModel.contactState.collectAsState()

    LaunchedEffect(contactState) {
        when (contactState) {
            is ContactState.Success -> { Toast.makeText(context, context.getString(R.string.enviar_email), Toast.LENGTH_SHORT).show()
                viewModel.resetState()
            }
            is ContactState.Error -> { Toast.makeText(context,(contactState as ContactState.Error).message, Toast.LENGTH_SHORT).show()
                viewModel.resetState()
            }
            else -> Unit
        }
    }

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
            fontSize = 26.sp
        )

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
            onClick = { viewModel.sendEmail(context) },
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


