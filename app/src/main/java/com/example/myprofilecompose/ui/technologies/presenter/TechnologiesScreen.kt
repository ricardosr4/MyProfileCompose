package com.example.myprofilecompose.ui.technologies.presenter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myprofilecompose.ui.theme.Purple40

@Composable
fun TechnologiesScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp)) // Espacio entre el título y el listado
            // Llama al LazyColumn con la lista de tecnologías
            SkillList(skills = getSkills())
        }
    }
}

@Composable
fun SkillList(skills: List<Pair<String, String>>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(skills) { skill ->
            SkillItem(name = skill.first, description = skill.second)
        }
    }
}

@Composable
fun SkillItem(name: String, description: String) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, color = Purple40),
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.align(Alignment.Start)
            )
            Divider(
                color = Purple40,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = description,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.align(Alignment.Start)
            )
        }
    }
}

fun getSkills(): List<Pair<String, String>> {
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
