package com.example.myprofilecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myprofilecompose.data.model.MenuItem
import com.example.myprofilecompose.navigation.AppScreen
import com.example.myprofilecompose.ui.aboutme.presenter.AboutMeScreen
import com.example.myprofilecompose.ui.gallery.GalleryScreen
import com.example.myprofilecompose.ui.home.presenter.HomeScreen
import com.example.myprofilecompose.ui.navigationdrawer.presenter.DrawerBody
import com.example.myprofilecompose.ui.navigationdrawer.presenter.DrawerHeader
import com.example.myprofilecompose.ui.navigationdrawer.presenter.TopAppBar
import com.example.myprofilecompose.ui.projects.presenter.ProjectsScreen
import com.example.myprofilecompose.ui.technologies.presenter.TechnologiesScreen
import com.example.myprofilecompose.ui.theme.MyProfileComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val title = remember { mutableStateOf("Home") }
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            val navigationController = rememberNavController()

            MyProfileComposeTheme {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar(title = title.value) {
                            scope.launch { scaffoldState.drawerState.open() }
                        }
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "Home",
                                    title = "Home",
                                    contentDescription = "Go to home screen",
                                    icon = Icons.Default.Home
                                ),
                                MenuItem(
                                    id = "About Me",
                                    title = "Sobre Mi",
                                    contentDescription = "Go to About Me",
                                    icon = Icons.Default.Person
                                ),
                                MenuItem(
                                    id = "Projects",
                                    title = "Proyectos",
                                    contentDescription = "Go to Projects",
                                    icon = Icons.Default.Star
                                ),
                                MenuItem(
                                    id = "Gallery",
                                    title = "Galeria",
                                    contentDescription = "Go to Projects",
                                    icon = Icons.Default.PlayArrow
                                ),
                                MenuItem(
                                    id = "Technologies",
                                    title = "Tecnologías",
                                    contentDescription = "Go to Technologies",
                                    icon = Icons.Default.Build
                                )
                            ),
                            onItemClick = {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                    when (it.id) {
                                        "Home" -> {
                                            title.value = "Home"
                                            navigationController.navigate(AppScreen.HomeScreen.route)
                                        }

                                        "About Me" -> {
                                            title.value = "Sobre Mi"
                                            navigationController.navigate(AppScreen.AboutMeScreen.route)
                                        }

                                        "Projects" -> {
                                            title.value = "Proyectos"
                                            navigationController.navigate(AppScreen.ProjectScreen.route)
                                        }
                                        "Gallery" -> {
                                            title.value = "Galeria"
                                            navigationController.navigate(AppScreen.GalleryScreen.route)
                                        }

                                        "Technologies" -> {
                                            title.value = "Tecnologias"
                                            navigationController.navigate(AppScreen.TechnologiesScreen.route)
                                        }
                                    }
                                }
                            }
                        )
                    }
                ) {
                    NavHost(
                        navController = navigationController,
                        startDestination = AppScreen.HomeScreen.route
                    ) {
                        composable(AppScreen.HomeScreen.route) { HomeScreen() }
                        composable(AppScreen.AboutMeScreen.route) { AboutMeScreen() }
                        composable(AppScreen.ProjectScreen.route) { ProjectsScreen() }
                        composable(AppScreen.GalleryScreen.route) { GalleryScreen() }
                        composable(AppScreen.TechnologiesScreen.route) { TechnologiesScreen() }
                    }
                }
            }
        }
    }
}

