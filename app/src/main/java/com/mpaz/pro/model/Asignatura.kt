package com.mpaz.pro.model

// Modelos de contenido para la demo

data class Pregunta(
    val enunciado: String,
    val alternativas: List<String>,
    val correcta: Int // posicion de la alternativa correcta
)

data class Asignatura(
    val nombre: String,
    val icono: String,
    val unidad: String,
    val objetivo: String,
    val explicacion: String,
    val ejemplo: String,
    val preguntas: List<Pregunta>
)
