package com.example.myprofilecompose.ui.aboutme.state

sealed class AboutMeState {
    sealed class PdfSaveState {
        data object Success : PdfSaveState()
        data class Error(val message: String) : PdfSaveState()
    }
}