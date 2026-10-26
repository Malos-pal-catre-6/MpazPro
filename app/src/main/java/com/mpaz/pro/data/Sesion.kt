package com.mpaz.pro.data

import com.mpaz.pro.model.User

// Guarda en memoria quien inicio sesion. Se pierde al cerrar la app
object Sesion {
    var usuarioActual: User? = null

    fun cerrar() {
        usuarioActual = null
    }
}
