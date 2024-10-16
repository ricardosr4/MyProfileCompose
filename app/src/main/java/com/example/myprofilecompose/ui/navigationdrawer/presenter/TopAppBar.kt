package com.example.myprofilecompose.ui.navigationdrawer.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myprofilecompose.ui.theme.gradientBrush


@Composable
fun TopAppBar(
    title: String,
    onClickDrawer: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(gradientBrush)
    ) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = title)
                }
            },
            backgroundColor = Color.Transparent,
            contentColor = Color.Black,
            navigationIcon = {
                IconButton(onClick = { onClickDrawer() }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Menu")
                }
            },
            actions = {
                Spacer(modifier = Modifier.width(72.dp))
            }
        )
    }
}

