package com.mpaz.pro.ui.components

import android.content.Context
import android.widget.Toast

// Mensaje que piden las instrucciones para los formularios que aun no guardan datos.
fun mostrarAvisoFuturo(context: Context) {
    Toast.makeText(context, "Para una futura actualización", Toast.LENGTH_SHORT).show()
}
