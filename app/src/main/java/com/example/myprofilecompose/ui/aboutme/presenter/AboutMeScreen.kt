package com.example.myprofilecompose.ui.aboutme.presenter

import android.content.Context
import android.os.Environment
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.myprofilecompose.R
import com.example.myprofilecompose.ui.theme.gradientBrush
import com.example.myprofilecompose.ui.theme.gradientButtonMetallic
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

@Preview(showBackground = true)
@Composable
fun AboutMeScreen() {
    val context = LocalContext.current
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
                painter = painterResource(id = R.drawable.img_cv_example),
                contentDescription = stringResource(R.string.imagen_cv),
            )
        }

        Button(
            onClick = { savePdfToDownloads(context) },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
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
}

fun savePdfToDownloads(context: Context) {
    try {
        val fileName = "cv.ricardo.dev.pdf"
        val assetManager = context.assets
        val inputStream: InputStream = assetManager.open(fileName)
        val file = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            fileName
        )
        val outputStream: OutputStream = FileOutputStream(file)
        val buffer = ByteArray(1024)
        var length: Int
        while (inputStream.read(buffer).also { length = it } > 0) {
            outputStream.write(buffer, 0, length)
        }
        outputStream.flush()
        outputStream.close()
        inputStream.close()
        Toast.makeText(context, "CV guardado en Descargas", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Error al guardar el CV", Toast.LENGTH_SHORT).show()
    }
}
