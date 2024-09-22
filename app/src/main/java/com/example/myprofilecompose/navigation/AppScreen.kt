package com.example.myprofilecompose.navigation

sealed class AppScreen(val route: String) {
    data object AboutMeScreen : AppScreen("AboutMeScreen")
    data object HomeScreen : AppScreen("HomeScreen")
    data object ProjectScreen : AppScreen("ProjectScreen")
    data object TechnologiesScreen : AppScreen("TechnologiesScreen")
}