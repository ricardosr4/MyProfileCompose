package com.example.myprofilecompose.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myprofilecompose.R
import com.example.myprofilecompose.ui.aboutme.presenter.AboutMeScreen
import com.example.myprofilecompose.ui.contact.presenter.ContactScreen
import com.example.myprofilecompose.ui.home.presenter.HomeScreen
import com.example.myprofilecompose.ui.projects.presenter.ProjectScreen
import com.example.myprofilecompose.ui.technologies.presenter.TechnologiesScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    onTitleChange: (String) -> Unit,
    context: Context
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.HomeScreen.route
    ) {
        composable(AppScreen.HomeScreen.route) {
            HomeScreen(
                onTitleChange = onTitleChange,
                navController = navController
            )
            LaunchedEffect(Unit) {
                onTitleChange(context.getString(R.string.home))
            }
        }
        composable(AppScreen.AboutMeScreen.route) {
            AboutMeScreen()
            LaunchedEffect(Unit) {
                onTitleChange(context.getString(R.string.about_me))
            }
        }
        composable(AppScreen.ProjectScreen.route) {
            ProjectScreen()
            LaunchedEffect(Unit) {
                onTitleChange(context.getString(R.string.projects))
            }
        }
        composable(AppScreen.TechnologiesScreen.route) {
            TechnologiesScreen()
            LaunchedEffect(Unit) {
                onTitleChange(context.getString(R.string.technologies))
            }
        }
        composable(AppScreen.ContactScreen.route) {
            ContactScreen()
            LaunchedEffect(Unit) {
                onTitleChange(context.getString(R.string.contact))
            }
        }
    }
}