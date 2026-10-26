package com.mpaz.pro.ui.screens.estudiante

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun EstInicioScreen(
    onVerAsignaturas: () -> Unit,
    onVerResultados: () -> Unit,
    onCerrarSesion: () -> Unit
) {
    val nombre = Sesion.usuarioActual?.nombre ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¡Hola, $nombre!",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "¿Qué quieres hacer hoy?",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = onVerAsignaturas,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📚 Mis asignaturas")
        }

        Spacer(Modifier.height(12.dp))

        OutlinedButton(
            onClick = onVerResultados,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📝 Mis resultados")
        }

        Spacer(Modifier.height(24.dp))

        TextButton(onClick = onCerrarSesion) {
            Text("Cerrar sesión")
        }
    }
}
