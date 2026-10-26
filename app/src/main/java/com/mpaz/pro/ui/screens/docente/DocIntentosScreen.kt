package com.mpaz.pro.ui.screens.docente

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mpaz.pro.data.DatosDemo
import com.mpaz.pro.ui.components.CabeceraPantalla
import com.mpaz.pro.ui.components.mostrarAvisoFuturo

@Composable
fun DocIntentosScreen(onVolver: () -> Unit) {
    val context = LocalContext.current

    var intentos by remember { mutableStateOf(DatosDemo.INTENTOS_MAXIMOS.toString()) }
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        CabeceraPantalla("Límite de intentos", onVolver)

        Text("Define cuántas veces puede rendir la prueba final cada estudiante.")
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = intentos,
            onValueChange = { intentos = it },
            label = { Text("Intentos máximos (1 a 10)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        if (error.isNotEmpty()) {
            Spacer(Modifier.height(8.dp))
            Text(text = error, color = MaterialTheme.colorScheme.error)
        }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                val numero = intentos.toIntOrNull()
                if (numero == null || numero < 1 || numero > 10) {
                    error = "Escribe un número entre 1 y 10"
                } else {
                    error = ""
                    mostrarAvisoFuturo(context)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar límite")
        }
    }
}
