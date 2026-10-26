package com.mpaz.pro.ui.screens.docente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.Sesion

@Composable
fun DocInicioScreen(
    onObjetivos: () -> Unit,
    onAsignar: () -> Unit,
    onIntentos: () -> Unit,
    onResultados: () -> Unit,
    onInforme: () -> Unit,
    onCerrarSesion: () -> Unit
) {
    val nombre = Sesion.usuarioActual?.nombre ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hola, $nombre",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Panel del docente · Sexto Básico",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(24.dp))

        Button(onClick = onObjetivos, modifier = Modifier.fillMaxWidth()) {
            Text("📌 Objetivos de aprendizaje")
        }
        Spacer(Modifier.height(8.dp))
        Button(onClick = onAsignar, modifier = Modifier.fillMaxWidth()) {
            Text("📤 Asignar contenidos y desafíos")
        }
        Spacer(Modifier.height(8.dp))
        Button(onClick = onIntentos, modifier = Modifier.fillMaxWidth()) {
            Text("🔁 Límite de intentos")
        }
        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = onResultados, modifier = Modifier.fillMaxWidth()) {
            Text("📊 Resultados del curso")
        }
        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = onInforme, modifier = Modifier.fillMaxWidth()) {
            Text("📄 Informe pedagógico")
        }

        Spacer(Modifier.height(24.dp))

        TextButton(onClick = onCerrarSesion) {
            Text("Cerrar sesión")
        }
    }
}
