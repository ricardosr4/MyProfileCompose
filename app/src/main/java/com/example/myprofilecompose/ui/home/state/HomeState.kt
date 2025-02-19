package com.example.myprofilecompose.ui.home.state

sealed class HomeState{
    data class OpenLink(val url: String) : HomeState()
    data class NavigateTo(val route: String, val title: String) : HomeState()
}
