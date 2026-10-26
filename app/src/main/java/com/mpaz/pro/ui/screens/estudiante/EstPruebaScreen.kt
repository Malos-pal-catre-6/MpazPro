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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.DatosDemo
import com.mpaz.pro.ui.components.CabeceraPantalla
import com.mpaz.pro.ui.components.PreguntaCard
import com.mpaz.pro.ui.components.mostrarAvisoFuturo

@Composable
fun EstPruebaScreen(
    onVerResultados: () -> Unit,
    onVolver: () -> Unit
) {
    val context = LocalContext.current
    val asignatura = DatosDemo.seleccionada

    // Una respuesta elegida por pregunta (-1 = sin responder).
    val selecciones = remember {
        mutableStateListOf<Int>().apply {
            repeat(asignatura.preguntas.size) { add(-1) }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        CabeceraPantalla("Prueba final", onVolver)

        Text("${asignatura.nombre} · ${asignatura.unidad}")
        Spacer(Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Text(
                text = "Intentos usados: 0 de ${DatosDemo.INTENTOS_MAXIMOS} " +
                    "(límite definido por tu docente)",
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(Modifier.height(12.dp))

        asignatura.preguntas.forEachIndexed { posicion, pregunta ->
            PreguntaCard(
                numero = posicion + 1,
                pregunta = pregunta,
                seleccion = selecciones[posicion],
                onSeleccion = { selecciones[posicion] = it }
            )
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                mostrarAvisoFuturo(context)
                onVerResultados()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Finalizar prueba")
        }
    }
}
