package com.example.myprofilecompose.ui.aboutme.presenter

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myprofilecompose.R
import com.example.myprofilecompose.ui.aboutme.state.AboutMeState
import com.example.myprofilecompose.ui.aboutme.viewModel.AboutMeViewModel
import com.example.myprofilecompose.ui.theme.Purple40

@Composable
fun AboutMeScreen(viewModel: AboutMeViewModel = viewModel()) {

    val context = LocalContext.current
    val saveState by viewModel.saveState.collectAsState()

    LaunchedEffect(saveState) {
        when (saveState) {
            is AboutMeState.PdfSaveState.Success -> {
                Toast.makeText(context, context.getString(R.string.cv_saved_success), Toast.LENGTH_SHORT).show()
                viewModel.resetState()
            }
            is AboutMeState.PdfSaveState.Error -> {
                Toast.makeText(context, (saveState as AboutMeState.PdfSaveState.Error).message, Toast.LENGTH_SHORT).show()
                viewModel.resetState()
            }
            null -> Unit
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                alignment = Alignment.TopCenter,
                painter = painterResource(id = R.drawable.img_cv),
                contentDescription = stringResource(R.string.imagen_cv),
            )
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = { viewModel.savePdfToDownloads(context, "cv.ricardo.dev.2025.pdf") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple40,
                    contentColor = Color.White
                )
            ) {
                Text(text = stringResource(R.string.download_cv))
            }
        }
    }
}

