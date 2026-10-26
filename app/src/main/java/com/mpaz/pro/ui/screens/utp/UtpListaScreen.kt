package com.mpaz.pro.ui.screens.utp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.DatosDemo
import com.mpaz.pro.data.DatosUtp
import com.mpaz.pro.ui.components.CabeceraPantalla

@Composable
fun UtpListaScreen(
    onAbrir: () -> Unit,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        CabeceraPantalla("Contenidos por revisar", onVolver)

        DatosDemo.asignaturas.forEach { asignatura ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable {
                        DatosDemo.seleccionada = asignatura
                        onAbrir()
                    }
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = asignatura.icono,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(Modifier.width(16.dp))
                    Column {
                        Text(
                            text = asignatura.nombre,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = asignatura.unidad,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Estado: ${DatosUtp.estadoDe(asignatura)}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}
