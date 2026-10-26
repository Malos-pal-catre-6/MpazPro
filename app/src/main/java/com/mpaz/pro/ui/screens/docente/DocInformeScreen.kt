package com.mpaz.pro.ui.screens.docente

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.DatosDemo
import com.mpaz.pro.data.Sesion
import com.mpaz.pro.ui.components.CabeceraPantalla
import com.mpaz.pro.ui.components.mostrarAvisoFuturo

// Informe de EJEMPLO para un estudiante . Solo lo ve el docente.
@Composable
fun DocInformeScreen(onVolver: () -> Unit) {
    val context = LocalContext.current
    val asignatura = DatosDemo.asignaturas[1] // Matematica
    val docente = Sesion.usuarioActual?.nombre ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        CabeceraPantalla("Informe pedagógico", onVolver)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Dato("Estudiante", "Estudiante ficticio 02")
                Dato("Asignatura y unidad", "${asignatura.nombre} · ${asignatura.unidad}")
                Dato("Objetivo de aprendizaje", asignatura.objetivo)
                Dato("Rendimiento", "50 % (1 de 2 respuestas correctas)")
                Dato("Respuestas correctas", "Pregunta 1: suma de fracciones con igual denominador")
                Dato("Respuestas incorrectas", "Pregunta 2: equivalencia entre fracciones impropias y números mixtos")
                Dato("Fortalezas identificadas", "Suma de fracciones con igual denominador")
                Dato("Contenidos que necesitan refuerzo", "Fracciones impropias y números mixtos")
                Dato("Fecha de generación", "23-10-2026 (ejemplo)")
                Dato("Docente responsable", docente)
                Dato("Estado del informe", "Pendiente de validación")
            }
        }

        Spacer(Modifier.height(8.dp))
        Text(
            text = "Este informe se arma con reglas simples según las respuestas correctas " +
                "e incorrectas. No es un diagnóstico y requiere tu validación como docente.",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { mostrarAvisoFuturo(context) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Validar informe")
        }
        Spacer(Modifier.height(8.dp))
        OutlinedButton(
            onClick = { mostrarAvisoFuturo(context) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Descargar informe")
        }
    }
}

// Titulo en negrita + valor, para no repetir el mismo bloque once veces.
@Composable
private fun Dato(titulo: String, valor: String) {
    Text(text = titulo, style = MaterialTheme.typography.titleSmall)
    Text(text = valor)
    Spacer(Modifier.height(8.dp))
}
