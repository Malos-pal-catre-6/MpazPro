package com.mpaz.pro.data

import com.mpaz.pro.model.Asignatura

// Estado de cada contenido segun el caso: borrador, en revision, autorizado o publicado.
// Son datos de EJEMPLO, en el mismo orden que DatosDemo.asignaturas.
object DatosUtp {

    private val estados = listOf(
        "En revisión",   // Lenguaje y Comunicación
        "Autorizado",    // Matemática
        "Borrador",      // Ciencias Naturales
        "En revisión"    // Historia, Geografía y Cs. Sociales
    )

    fun estadoDe(asignatura: Asignatura): String {
        val posicion = DatosDemo.asignaturas.indexOf(asignatura)
        return if (posicion in estados.indices) estados[posicion] else "Borrador"
    }
}
