package com.mpaz.pro.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.Sesion

// Pantalla TEMPORAL para comprobar que el login lleva a la pantalla del perfil correcto.
@Composable
fun InicioProvisorio(
    perfil: String,
    onCerrarSesion: () -> Unit
) {
    val nombre = Sesion.usuarioActual?.nombre ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hola, $nombre",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Perfil: $perfil",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.height(8.dp))
        Text("Las pantallas de este perfil se agregan en las siguientes partes.")
        Spacer(Modifier.height(24.dp))
        Button(onClick = onCerrarSesion) {
            Text("Cerrar sesión")
        }
    }
}
