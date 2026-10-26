package com.mpaz.pro.ui.screens.estudiante

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.DatosDemo
import com.mpaz.pro.ui.components.CabeceraPantalla

// El estudiante solo ve sus respuestas correctas e incorrectas.
// NO ve el informe pedagogico ni el analisis de fortalezas (eso es solo del docente).
// Los resultados son de EJEMPLO: la primera pregunta de cada asignatura sale correcta
// y la segunda incorrecta.
@Composable
fun EstResultadosScreen(onVolver: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        CabeceraPantalla("Mis resultados", onVolver)

        Text(
            text = "Resultados de ejemplo (datos ficticios).",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(12.dp))

        DatosDemo.asignaturas.forEach { asignatura ->
            Text(
                text = "${asignatura.icono} ${asignatura.nombre}",
                style = MaterialTheme.typography.titleMedium
            )

            asignatura.preguntas.forEachIndexed { posicion, pregunta ->
                val esCorrecta = posicion == 0
                val respuestaElegida = if (esCorrecta) {
                    pregunta.correcta
                } else {
                    (pregunta.correcta + 1) % pregunta.alternativas.size
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(pregunta.enunciado)
                        Text("Tu respuesta: ${pregunta.alternativas[respuestaElegida]}")
                        if (esCorrecta) {
                            Text("✔ Correcta", color = MaterialTheme.colorScheme.secondary)
                        } else {
                            Text("✘ Incorrecta", color = MaterialTheme.colorScheme.error)
                            Text("Respuesta correcta: ${pregunta.alternativas[pregunta.correcta]}")
                        }
                    }
                }
            }
            Spacer(Modifier.height(12.dp))
        }
    }
}
