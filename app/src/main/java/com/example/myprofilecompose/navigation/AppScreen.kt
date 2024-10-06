package com.example.myprofilecompose.navigation

sealed class AppScreen(val route: String) {
    //en esta sealed class manejaremos la navegacion
    data object AboutMeScreen : AppScreen("AboutMeScreen")
    data object HomeScreen : AppScreen("HomeScreen")
    data object ProjectScreen : AppScreen("ProjectScreen")
    data object TechnologiesScreen : AppScreen("TechnologiesScreen")
    data object GalleryScreen : AppScreen("GalleryScreen")
}