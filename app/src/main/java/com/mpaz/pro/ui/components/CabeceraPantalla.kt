package com.mpaz.pro.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Titulo de pantalla con boton "Volver" opcional. Lo usan todas las pantallas de los perfiles.
@Composable
fun CabeceraPantalla(titulo: String, onVolver: (() -> Unit)? = null) {
    Column {
        if (onVolver != null) {
            TextButton(onClick = onVolver) {
                Text("← Volver")
            }
        }
        Text(
            text = titulo,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(12.dp))
    }
}
