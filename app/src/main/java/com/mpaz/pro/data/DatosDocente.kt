package com.mpaz.pro.data

// Resultados de EJEMPLO para la pantalla del docente
data class ResultadoEjemplo(
    val estudiante: String,
    val asignatura: String,
    val correctas: Int,
    val total: Int,
    val intentos: Int,
    val estado: String
)

object DatosDocente {

    const val CURSO = "6.º A"

    val resultados = listOf(
        ResultadoEjemplo("Estudiante  01", "Matemática", 2, 2, 1, "Completado"),
        ResultadoEjemplo("Estudiante  02", "Matemática", 1, 2, 2, "Completado"),
        ResultadoEjemplo("Estudiante  03", "Lenguaje y Comunicación", 1, 2, 1, "Completado"),
        ResultadoEjemplo("Estudiante  04", "Ciencias Naturales", 0, 2, 1, "Completado"),
        ResultadoEjemplo("Estudiante  05", "Historia, Geografía y Cs. Sociales", 0, 0, 0, "Sin iniciar")
    )
}
