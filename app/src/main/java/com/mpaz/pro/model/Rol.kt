package com.mpaz.pro.model

// Los tres perfiles que define el caso.
enum class Rol(val etiqueta: String) {
    ESTUDIANTE("Estudiante"),
    DOCENTE("Docente"),
    UTP("Jefatura UTP");

    companion object {
        // Convierte el texto guardado en SQLite de vuelta a Rol.
        fun desdeTexto(texto: String): Rol =
            entries.firstOrNull { it.name == texto } ?: ESTUDIANTE
    }
}
