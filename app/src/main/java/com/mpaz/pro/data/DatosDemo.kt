package com.mpaz.pro.data

import com.mpaz.pro.model.Asignatura
import com.mpaz.pro.model.Pregunta

object DatosDemo {

    val asignaturas = listOf(
        Asignatura(
            nombre = "Lenguaje y Comunicación",
            icono = "📖",
            unidad = "Analizamos cuentos",
            objetivo = "LE06 OA 04 · Analizar narraciones: sus acciones principales, " +
                "las actitudes de los personajes y el ambiente en que ocurren los hechos.",
            explicacion = "Un cuento cuenta una historia. Para analizarlo, fíjate en tres cosas: " +
                "las acciones principales (lo que pasa), los personajes (cómo actúan y qué sienten) " +
                "y el ambiente (el lugar y la época donde ocurre todo). Lo que un personaje hace " +
                "o dice nos ayuda a conocer cómo es.",
            ejemplo = "En un cuento inventado, \"El zorro y la luna\", el zorro sale de noche a " +
                "buscar comida (acción), es curioso y valiente (personaje) y todo ocurre en un " +
                "bosque oscuro (ambiente).",
            preguntas = listOf(
                Pregunta(
                    "En un cuento, ¿cómo se llama el lugar y la época donde ocurren los hechos?",
                    listOf("Personaje", "Ambiente", "Moraleja"),
                    1
                ),
                Pregunta(
                    "¿Qué nos muestran las acciones y reacciones de un personaje?",
                    listOf("Cómo es y qué siente", "Cuántas páginas tiene el cuento", "Quién lo ilustró"),
                    0
                )
            )
        ),
        Asignatura(
            nombre = "Matemática",
            icono = "🔢",
            unidad = "Fracciones y números mixtos",
            objetivo = "MA06 OA 05 y OA 06 · Comprender las fracciones y los números mixtos " +
                "(equivalencia entre fracciones impropias y números mixtos) y resolver sumas " +
                "y restas con ellos.",
            explicacion = "Una fracción impropia tiene el numerador mayor que el denominador, " +
                "como 5/4. Se puede escribir como número mixto: un entero y una fracción. " +
                "Para sumar fracciones con el mismo denominador, se suman los numeradores " +
                "y el denominador se mantiene.",
            ejemplo = "5/4 es lo mismo que 1 1/4, porque 4/4 forman un entero y sobra 1/4. " +
                "Además, 2/8 + 3/8 = 5/8.",
            preguntas = listOf(
                Pregunta(
                    "¿Cuánto es 1/5 + 2/5?",
                    listOf("3/5", "3/10", "2/5"),
                    0
                ),
                Pregunta(
                    "¿Qué número mixto es igual a 5/4?",
                    listOf("1 1/4", "1 4/5", "4 1/5"),
                    0
                )
            )
        ),
        Asignatura(
            nombre = "Ciencias Naturales",
            icono = "🔬",
            unidad = "La materia y sus cambios de estado",
            objetivo = "CN06 OA 12 y OA 13 · Explicar con modelos que la materia está formada " +
                "por partículas en movimiento (sólido, líquido y gas) y reconocer sus cambios " +
                "de estado.",
            explicacion = "Todo lo que nos rodea es materia, y está formada por partículas muy " +
                "pequeñas que se mueven. En un sólido se mueven poco, en un líquido se mueven más " +
                "y en un gas se mueven mucho. Al calentar o enfriar, la materia cambia de estado: " +
                "fusión (sólido a líquido), solidificación (líquido a sólido), evaporación " +
                "(líquido a gas) y condensación (gas a líquido).",
            ejemplo = "Un cubo de hielo se derrite al sacarlo del congelador: pasa de sólido a " +
                "líquido, es decir, ocurre una fusión.",
            preguntas = listOf(
                Pregunta(
                    "¿En qué estado de la materia las partículas se mueven menos?",
                    listOf("Líquido", "Sólido", "Gaseoso"),
                    1
                ),
                Pregunta(
                    "¿Cómo se llama el cambio de líquido a sólido al enfriar?",
                    listOf("Solidificación", "Fusión", "Evaporación"),
                    0
                )
            )
        ),
        Asignatura(
            nombre = "Historia, Geografía y Cs. Sociales",
            icono = "🌎",
            unidad = "Derechos y deberes de las personas",
            objetivo = "HI06 OA 17 y OA 18 · Comprender que todas las personas tienen derechos " +
                "que deben ser respetados, y que esos derechos generan deberes y " +
                "responsabilidades.",
            explicacion = "Todas las personas tienen derechos, que son cosas que nos " +
                "corresponden para vivir bien, como estudiar, tener salud y ser tratados con " +
                "respeto. Los derechos generan deberes: son compromisos que cumplimos para " +
                "convivir en comunidad, como respetar a los demás y cuidar los espacios " +
                "que compartimos.",
            ejemplo = "Tengo derecho a estudiar y tengo el deber de respetar a mis " +
                "compañeros y a mis profesores.",
            preguntas = listOf(
                Pregunta(
                    "¿Cuál de estos es un derecho de niñas y niños?",
                    listOf("Dañar los espacios comunes", "Faltar a clases", "Recibir educación"),
                    2
                ),
                Pregunta(
                    "¿Cuál de estos es un deber?",
                    listOf("Ser tratado con respeto", "Respetar a los demás", "Faltar a clases"),
                    1
                )
            )
        )
    )

    // Asignatura que el usuario eligio (la usan las pantallas de contenido, actividad y prueba).
    var seleccionada: Asignatura = asignaturas[0]

    // Dato de ejemplo: el limite de intentos lo configura el docente (pantalla del docente).
    const val INTENTOS_MAXIMOS = 3
}
