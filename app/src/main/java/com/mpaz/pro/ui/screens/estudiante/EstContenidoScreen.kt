package com.mpaz.pro.ui.screens.estudiante

import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpaz.pro.data.DatosDemo
import com.mpaz.pro.ui.components.CabeceraPantalla
import com.mpaz.pro.ui.components.mostrarAvisoFuturo

@Composable
fun EstContenidoScreen(
    onActividad: () -> Unit,
    onPrueba: () -> Unit,
    onVolver: () -> Unit
) {
    val context = LocalContext.current
    val asignatura = DatosDemo.seleccionada

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        CabeceraPantalla(asignatura.nombre, onVolver)

        Text(
            text = asignatura.unidad,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(Modifier.height(12.dp))

        // Recurso visual de apoyo (simple, con el icono de la asignatura).
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = asignatura.icono, fontSize = 64.sp)
            }
        }

        Spacer(Modifier.height(16.dp))
        Text("Objetivo de aprendizaje", style = MaterialTheme.typography.titleMedium)
        Text(asignatura.objetivo)

        Spacer(Modifier.height(16.dp))
        Text("Explicación", style = MaterialTheme.typography.titleMedium)
        Text(asignatura.explicacion)

        Spacer(Modifier.height(16.dp))
        Text("Ejemplo", style = MaterialTheme.typography.titleMedium)
        Text(asignatura.ejemplo)

        Spacer(Modifier.height(16.dp))
        OutlinedButton(
            onClick = { mostrarAvisoFuturo(context) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🔊 Escuchar audio de apoyo")
        }

        Spacer(Modifier.height(8.dp))
        Button(
            onClick = onActividad,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Hacer la actividad")
        }

        Spacer(Modifier.height(8.dp))
        OutlinedButton(
            onClick = onPrueba,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a la prueba final")
        }
    }
}
