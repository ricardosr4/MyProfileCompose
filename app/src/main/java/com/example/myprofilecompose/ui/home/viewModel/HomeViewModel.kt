package com.example.myprofilecompose.ui.home.viewModel

import androidx.lifecycle.ViewModel
import com.example.myprofilecompose.ui.home.state.HomeState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class HomeViewModel: ViewModel() {

    private val _events = MutableSharedFlow<HomeState>()
    val events: SharedFlow<HomeState> = _events.asSharedFlow()

    suspend fun sendEvent(event: HomeState) {
        _events.emit(event)
    }
}