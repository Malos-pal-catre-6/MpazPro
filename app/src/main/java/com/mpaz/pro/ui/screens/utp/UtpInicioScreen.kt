package com.mpaz.pro.ui.screens.utp

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.Sesion

@Composable
fun UtpInicioScreen(
    onRevisar: () -> Unit,
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
            text = "Jefatura de UTP · Segundo Ciclo",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Text(
                text = "Revisa y autoriza los contenidos de Sexto Básico. " +
                    "En esta versión hay una unidad por asignatura.",
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = onRevisar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📋 Contenidos por revisar")
        }

        Spacer(Modifier.height(24.dp))

        TextButton(onClick = onCerrarSesion) {
            Text("Cerrar sesión")
        }
    }
}
