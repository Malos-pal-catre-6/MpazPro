package com.mpaz.pro.ui.screens.estudiante

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.DatosDemo
import com.mpaz.pro.ui.components.CabeceraPantalla
import com.mpaz.pro.ui.components.PreguntaCard
import com.mpaz.pro.ui.components.mostrarAvisoFuturo

@Composable
fun EstActividadScreen(
    onPrueba: () -> Unit,
    onVolver: () -> Unit
) {
    val context = LocalContext.current
    val asignatura = DatosDemo.seleccionada
    var seleccion by remember { mutableIntStateOf(-1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        CabeceraPantalla("Actividad", onVolver)

        Text("${asignatura.nombre} · ${asignatura.unidad}")
        Spacer(Modifier.height(12.dp))

        PreguntaCard(
            numero = 1,
            pregunta = asignatura.preguntas[0],
            seleccion = seleccion,
            onSeleccion = { seleccion = it }
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { mostrarAvisoFuturo(context) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Comprobar respuesta")
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
