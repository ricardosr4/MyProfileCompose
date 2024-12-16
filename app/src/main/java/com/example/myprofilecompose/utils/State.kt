package com.example.myprofilecompose.utils

sealed class State {

    data class Success(val data: String) : State()
    data class Error(val error: String) : State()
    data object Loading : State()

    //pensar si la app se manejara con sealed class o solamente data class
}