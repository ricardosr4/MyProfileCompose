package com.example.myprofilecompose.ui.aboutme.presenter

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myprofilecompose.R
import com.example.myprofilecompose.ui.aboutme.state.AboutMeState
import com.example.myprofilecompose.ui.aboutme.viewModel.AboutMeViewModel
import com.example.myprofilecompose.ui.theme.gradientBrush
import com.example.myprofilecompose.ui.theme.gradientButtonMetallic

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

        DownloadButton(
            onClick = { viewModel.savePdfToDownloads(context, "cv.ricardo.dev.2025.pdf") },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun DownloadButton(onClick: () -> Unit, modifier: Modifier) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        ),
        modifier = modifier
            .padding(20.dp)
            .width(300.dp)
            .background(brush = gradientButtonMetallic, shape = RoundedCornerShape(20.dp))
            .border(
                width = 4.dp,
                brush = gradientButtonMetallic,
                shape = RoundedCornerShape(20.dp)
            )
            .background(
                brush = gradientBrush,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Text(
            text = stringResource(R.string.descargar_cv),
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.White,
                shadow = Shadow(
                    color = Color.Black,
                    blurRadius = 3f
                )
            ),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

