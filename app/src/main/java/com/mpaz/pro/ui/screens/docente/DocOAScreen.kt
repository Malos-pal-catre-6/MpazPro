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
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.DatosDemo
import com.mpaz.pro.data.DatosDocente
import com.mpaz.pro.ui.components.CabeceraPantalla
import com.mpaz.pro.ui.components.mostrarAvisoFuturo

@Composable
fun DocOAScreen(onVolver: () -> Unit) {
    val context = LocalContext.current

    // Un casillero marcado por cada objetivo disponible.
    val seleccionados = remember {
        mutableStateListOf<Boolean>().apply {
            repeat(DatosDemo.asignaturas.size) { add(true) }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        CabeceraPantalla("Objetivos de aprendizaje", onVolver)

        Text("Selecciona los objetivos que trabajará el curso ${DatosDocente.CURSO}.")
        Spacer(Modifier.height(12.dp))

        DatosDemo.asignaturas.forEachIndexed { posicion, asignatura ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .clickable { seleccionados[posicion] = !seleccionados[posicion] }
                        .padding(8.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Checkbox(
                        checked = seleccionados[posicion],
                        onCheckedChange = { seleccionados[posicion] = it }
                    )
                    Column(modifier = Modifier.padding(top = 12.dp, end = 8.dp)) {
                        Text(
                            text = "${asignatura.icono} ${asignatura.nombre}",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = asignatura.unidad,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = asignatura.objetivo,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { mostrarAvisoFuturo(context) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar selección")
        }
    }
}
