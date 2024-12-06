package com.example.myprofilecompose.ui.aboutme.viewModel

import android.content.Context
import android.os.Environment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myprofilecompose.ui.aboutme.state.AboutMeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class AboutMeViewModel : ViewModel() {
    private val _saveState = MutableStateFlow<AboutMeState.PdfSaveState?>(null)
    val saveState: StateFlow<AboutMeState.PdfSaveState?> get() = _saveState

    fun savePdfToDownloads(context: Context, fileName: String) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val assetManager = context.assets
                    val inputStream = assetManager.open(fileName)
                    val file = File(
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                        fileName
                    )
                    inputStream.use { input ->
                        file.outputStream().use { output ->
                            input.copyTo(output)
                        }
                    }
                }
                _saveState.value = AboutMeState.PdfSaveState.Success
            } catch (e: Exception) {
                _saveState.value =
                    AboutMeState.PdfSaveState.Error("Error al guardar el CV: ${e.localizedMessage}")
            }
        }
    }

    fun resetState() {
        _saveState.value = null
    }
}
