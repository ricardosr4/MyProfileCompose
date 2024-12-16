package com.example.myprofilecompose.ui.contact.state

sealed class ContactState{
    data object Loading : ContactState()
    data object Success : ContactState()
    data class Error(val message: String) : ContactState()
}

