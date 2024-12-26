package com.example.myprofilecompose.ui.technologies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myprofilecompose.ui.technologies.state.TechnologiesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TechnologiesViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TechnologiesState())
    val uiState: StateFlow<TechnologiesState> get() = _uiState

    init {
        loadSkills()
    }

    private fun loadSkills() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                skills = getSkills()
            )
        }
    }

    private fun getSkills(): List<Pair<String, String>> {
        return listOf(
            "Kotlin" to "Lenguaje de programación moderno para Android y multiplataforma.",
            "MVVM" to "Patrón de arquitectura para separar la lógica de negocio y la interfaz.",
            "Coroutines" to "Manejo eficiente de hilos para operaciones asincrónicas.",
            "Retrofit" to "Cliente HTTP para consumir APIs REST de manera sencilla.",
            "Jetpack Compose" to "Nueva forma declarativa de construir interfaces en Android.",
            "Navigation Component" to "Librería para manejar la navegación en aplicaciones Android.",
            "RecyclerView" to "Componente para mostrar listas o grids con alto rendimiento.",
            "Git" to "Sistema de control de versiones distribuido para gestionar cambios en el código.",
            "Firebase" to "Plataforma para backend, análisis y notificaciones push.",
            "Room" to "Base de datos local para persistencia en aplicaciones Android.",
            "Hilt" to "Librería para inyección de dependencias de forma sencilla.",
            "Clean Architecture" to "Enfoque arquitectónico para mantener un código más limpio y escalable.",
            "Unit Testing" to "Pruebas de unidades para garantizar la calidad del código.",
            "LiveData" to "Observa y responde a cambios en los datos del ciclo de vida.",
            "ViewModel" to "Mantiene los datos relacionados con la UI durante cambios de configuración.",
            "View Binding" to "Simplifica el acceso a vistas sin usar `findViewById`.",
            "Shared Preferences" to "Almacena pequeños datos clave-valor en local.",
            "Picasso" to "Librería para cargar imágenes de manera eficiente.",
            "Lifecycle" to "Permite a los componentes reaccionar ante cambios en el ciclo de vida.",
            "ConstraintLayout" to "Diseña interfaces complejas con restricciones eficientes."

        )
    }
}

//data class TechnologiesUiState(
//    val skills: List<Pair<String, String>> = emptyList()
//)
