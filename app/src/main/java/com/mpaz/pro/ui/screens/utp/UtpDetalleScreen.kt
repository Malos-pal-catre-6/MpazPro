package com.mpaz.pro.ui.screens.utp

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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.DatosDemo
import com.mpaz.pro.data.DatosUtp
import com.mpaz.pro.ui.components.CabeceraPantalla
import com.mpaz.pro.ui.components.mostrarAvisoFuturo

@Composable
fun UtpDetalleScreen(onVolver: () -> Unit) {
    val context = LocalContext.current
    val asignatura = DatosDemo.seleccionada

    var objetivoOk by remember { mutableStateOf(false) }
    var actividadesOk by remember { mutableStateOf(false) }
    var origenOk by remember { mutableStateOf(false) }
    var observaciones by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        CabeceraPantalla("Revisión de contenido", onVolver)

        Text(
            text = "${asignatura.icono} ${asignatura.nombre}",
            style = MaterialTheme.typography.titleLarge
        )
        Text(asignatura.unidad)
        Text(
            text = "Estado actual: ${DatosUtp.estadoDe(asignatura)}",
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(Modifier.height(16.dp))
        Dato("Objetivo de aprendizaje", asignatura.objetivo)
        Dato("Explicación", asignatura.explicacion)
        Dato("Origen del material", "Propio")

        Text("Verificación", style = MaterialTheme.typography.titleMedium)
        FilaCasillero("El contenido se relaciona con el objetivo de aprendizaje", objetivoOk) {
            objetivoOk = it
        }
        FilaCasillero("Las actividades se relacionan con el objetivo", actividadesOk) {
            actividadesOk = it
        }
        FilaCasillero("El material es propio, público o autorizado", origenOk) {
            origenOk = it
        }

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = observaciones,
            onValueChange = { observaciones = it },
            label = { Text("Observaciones (opcional)") },
            minLines = 3,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { mostrarAvisoFuturo(context) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Autorizar contenido")
        }
        Spacer(Modifier.height(8.dp))
        OutlinedButton(
            onClick = { mostrarAvisoFuturo(context) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Devolver con observaciones")
        }
    }
}

// Titulo en negrita + valor, para no repetir el mismo bloque.
@Composable
private fun Dato(titulo: String, valor: String) {
    Text(text = titulo, style = MaterialTheme.typography.titleMedium)
    Text(text = valor)
    Spacer(Modifier.height(12.dp))
}

// Casillero con texto.
@Composable
private fun FilaCasillero(texto: String, marcado: Boolean, alCambiar: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { alCambiar(!marcado) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = marcado, onCheckedChange = alCambiar)
        Text(texto, modifier = Modifier.padding(end = 8.dp))
    }
}
