package com.mpaz.pro.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpaz.pro.model.Pregunta

// Una pregunta con alternativas. Se usa en la actividad y en la prueba final.
@Composable
fun PreguntaCard(
    numero: Int,
    pregunta: Pregunta,
    seleccion: Int,
    onSeleccion: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "$numero. ${pregunta.enunciado}",
                style = MaterialTheme.typography.titleMedium
            )
            pregunta.alternativas.forEachIndexed { posicion, texto ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSeleccion(posicion) },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = seleccion == posicion,
                        onClick = { onSeleccion(posicion) }
                    )
                    Text(texto)
                }
            }
        }
    }
}
