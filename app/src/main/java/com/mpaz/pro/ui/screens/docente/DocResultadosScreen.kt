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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.DatosDemo
import com.mpaz.pro.data.DatosDocente
import com.mpaz.pro.ui.components.CabeceraPantalla

@Composable
fun DocResultadosScreen(
    onInforme: () -> Unit,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        CabeceraPantalla("Resultados del curso", onVolver)

        Text("Curso ${DatosDocente.CURSO} · datos de ejemplo")
        Spacer(Modifier.height(12.dp))

        DatosDocente.resultados.forEach { resultado ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = resultado.estudiante,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(resultado.asignatura)
                    Text(
                        "Correctas: ${resultado.correctas} de ${resultado.total} · " +
                            "Intentos: ${resultado.intentos} de ${DatosDemo.INTENTOS_MAXIMOS}"
                    )
                    Text("Estado: ${resultado.estado}")
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = onInforme,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver informe pedagógico")
        }
    }
}
