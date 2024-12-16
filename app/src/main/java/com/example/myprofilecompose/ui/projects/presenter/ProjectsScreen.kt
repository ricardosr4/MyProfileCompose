package com.example.myprofilecompose.ui.projects.presenter

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myprofilecompose.R
import com.example.myprofilecompose.data.model.GalleryModel


@Preview(showBackground = true)
@Composable
fun ProjectScreen() {
    val context = LocalContext.current

    Column {
        TitleProjectXml()
        ProjectXml(context)
        TitleProjectCompose()
        ProjectCompose(context)
    }
}
@Composable
fun TitleProjectXml() {
    Text(
        text = stringResource(R.string.projects_xml),
        modifier = Modifier
            .padding(top = 10.dp, start = 50.dp),
        fontSize = 36.sp,
        fontFamily = FontFamily.Cursive
    )
}

@Composable
fun ProjectXml(context: android.content.Context) {
    LazyRow(
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(getProjectXml()) { galleryModel ->
            ItemProject(galleryModel = galleryModel) {
                Toast.makeText(context, it.nameProject, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
@Composable
fun TitleProjectCompose() {
    Text(
        text = stringResource(R.string.projects_compose),
        modifier = Modifier
            .padding(top = 10.dp, start = 50.dp),
        fontSize = 36.sp,
        fontFamily = FontFamily.Cursive
    )
}


@Composable
fun ProjectCompose(context: android.content.Context) {
    LazyRow(
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(getProjectCompose()) { galleryModel ->
            ItemProject(galleryModel = galleryModel) {
                Toast.makeText(context, it.nameProject, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemProject(galleryModel: GalleryModel, onItemSelected: (GalleryModel) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Gray),
        modifier = Modifier
            .width(150.dp)
            .height(300.dp)
            .clickable { onItemSelected(galleryModel) }
    ) {
        Column {
            Image(
                painter = painterResource(id = galleryModel.photo),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = galleryModel.nameProject,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

fun getProjectXml(): List<GalleryModel> {
    return listOf(
        GalleryModel(" Search Friends ", R.drawable.img_home_dogs),
        GalleryModel(" Search Friends", R.drawable.home_searchfriend_xml),
        GalleryModel(" Api Super Hero", R.drawable.img_api_sh_xml),
        GalleryModel(" Calculator", R.drawable.img_calculadora_xml),
        GalleryModel(" Login", R.drawable.img_login_first),
        GalleryModel(" Api Super Hero", R.drawable.img_recycler_sh_xml),
        GalleryModel(" Imc Calculator", R.drawable.img_imc_xml),
        GalleryModel(" Imc Calculator", R.drawable.img_imc_result),

    )
}

fun getProjectCompose(): List<GalleryModel> {
    return listOf(
        GalleryModel(" Compose", R.drawable.profile_compose),
        GalleryModel(" Compose", R.drawable.recover_password_compose),
        GalleryModel("Compose", R.drawable.img_contact_compose),
        GalleryModel(" Compose", R.drawable.img_drawer_compose),
        GalleryModel(" Compose", R.drawable.img_recycler_compose),

    )
}
