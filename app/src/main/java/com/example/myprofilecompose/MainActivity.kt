package com.example.myprofilecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myprofilecompose.data.model.MenuItem
import com.example.myprofilecompose.navigation.AppScreen
import com.example.myprofilecompose.navigation.NavGraph
import com.example.myprofilecompose.ui.aboutme.presenter.AboutMeScreen
import com.example.myprofilecompose.ui.contact.presenter.ContactScreen
import com.example.myprofilecompose.ui.home.presenter.HomeScreen
import com.example.myprofilecompose.ui.navigationdrawer.presenter.DrawerBody
import com.example.myprofilecompose.ui.navigationdrawer.presenter.DrawerHeader
import com.example.myprofilecompose.ui.navigationdrawer.presenter.TopAppBar
import com.example.myprofilecompose.ui.projects.presenter.ProjectScreen
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
                                    title = stringResource(R.string.home),
                                    contentDescription = "Go to home screen",
                                    icon = Icons.Default.Home
                                ),
                                MenuItem(
                                    id = "About Me",
                                    title = stringResource(R.string.about_me),
                                    contentDescription = "Go to About Me",
                                    icon = Icons.Default.Person
                                ),
                                MenuItem(
                                    id = "Projects",
                                    title = stringResource(R.string.projects),
                                    contentDescription = "Go to Projects",
                                    icon = Icons.Default.Star
                                ),
                                MenuItem(
                                    id = "Technologies",
                                    title = stringResource(R.string.technologies),
                                    contentDescription = "Go to Technologies",
                                    icon = Icons.Default.Build
                                ),
                                MenuItem(
                                    id = "Contact",
                                    title = stringResource(R.string.contact),
                                    contentDescription = "Go to Contact",
                                    icon = Icons.Default.Email
                                ),
                            ),
                            onItemClick = {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                    when (it.id) {
                                        "Home" -> { navigationController.navigate(AppScreen.HomeScreen.route) }
                                        "About Me" -> { navigationController.navigate(AppScreen.AboutMeScreen.route) }
                                        "Projects" -> { navigationController.navigate(AppScreen.ProjectScreen.route) }
                                        "Technologies" -> { navigationController.navigate(AppScreen.TechnologiesScreen.route) }
                                        "Contact" -> { navigationController.navigate(AppScreen.ContactScreen.route) }
                                    }
                                }
                            }
                        )
                    }
                ) {
                    NavGraph(
                        navController = navigationController,
                        onTitleChange = { title.value = it },
                        context = this
                    )
                }
            }
        }
    }
}

