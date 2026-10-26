package com.mpaz.pro.ui.screens.docente

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.DatosDemo
import com.mpaz.pro.data.DatosDocente
import com.mpaz.pro.ui.components.CabeceraPantalla
import com.mpaz.pro.ui.components.mostrarAvisoFuturo

@Composable
fun DocAsignarScreen(onVolver: () -> Unit) {
    val context = LocalContext.current

    var asignaturaElegida by remember { mutableIntStateOf(0) }
    var conContenido by remember { mutableStateOf(true) }
    var conActividades by remember { mutableStateOf(true) }
    var conDesafios by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        CabeceraPantalla("Asignar contenidos y desafíos", onVolver)

        Text("Curso: ${DatosDocente.CURSO}")
        Text(
            text = "Solo se pueden asignar contenidos autorizados por la Jefatura de UTP.",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(Modifier.height(16.dp))
        Text("Asignatura", style = MaterialTheme.typography.titleMedium)

        DatosDemo.asignaturas.forEachIndexed { posicion, asignatura ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { asignaturaElegida = posicion },
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = asignaturaElegida == posicion,
                    onClick = { asignaturaElegida = posicion }
                )
                Text("${asignatura.icono} ${asignatura.nombre}")
            }
        }

        Spacer(Modifier.height(16.dp))
        Text("¿Qué quieres asignar?", style = MaterialTheme.typography.titleMedium)

        FilaCasillero("Contenido explicativo", conContenido) { conContenido = it }
        FilaCasillero("Actividades", conActividades) { conActividades = it }
        FilaCasillero("Desafío", conDesafios) { conDesafios = it }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = { mostrarAvisoFuturo(context) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Asignar al curso")
        }
    }
}

// Casillero con texto, para no repetir el mismo codigo tres veces.
@Composable
private fun FilaCasillero(texto: String, marcado: Boolean, alCambiar: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { alCambiar(!marcado) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = marcado, onCheckedChange = alCambiar)
        Text(texto)
    }
}
