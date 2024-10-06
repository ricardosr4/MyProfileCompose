package com.example.myprofilecompose.ui.gallery

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
import androidx.compose.ui.unit.dp
import com.example.myprofilecompose.R
import com.example.myprofilecompose.data.model.GalleryModel

@Composable
fun GalleryScreen() {
    val context = LocalContext.current

    Column {
        ProjectXml(context)
        ProjectCompose(context)
    }
}

@Composable
fun ProjectXml(context: android.content.Context) {
    LazyRow(
        modifier = Modifier
            .padding(top = 20.dp, start = 10.dp),
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
fun ProjectCompose(context: android.content.Context) {
    LazyRow(
        modifier = Modifier
            .padding(top = 20.dp, start = 10.dp),
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
            .width(200.dp)
            .height(350.dp)
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
        GalleryModel("Search Friends XML", R.drawable.img_home_dogs),
        GalleryModel(" XML", R.drawable.img_home_dogs),
        GalleryModel(" XML", R.drawable.img_home_dogs),
        GalleryModel(" XML", R.drawable.img_home_dogs),
        GalleryModel(" XML", R.drawable.img_home_dogs),
        GalleryModel(" XML", R.drawable.img_home_dogs),
        GalleryModel(" XML", R.drawable.img_home_dogs)
    )
}

fun getProjectCompose(): List<GalleryModel> {
    return listOf(
        GalleryModel(" Compose", R.drawable.img_home_dogs),
        GalleryModel(" Compose", R.drawable.img_home_dogs),
        GalleryModel("Compose", R.drawable.img_home_dogs),
        GalleryModel(" Compose", R.drawable.img_home_dogs),
        GalleryModel(" Compose", R.drawable.img_home_dogs),
        GalleryModel("Compose", R.drawable.img_home_dogs),
        GalleryModel(" Compose", R.drawable.img_home_dogs)
    )
}
