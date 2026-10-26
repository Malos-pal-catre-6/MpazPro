package com.mpaz.pro.model

// Usuario de la app. La contrasena nunca se guarda en texto plano
// se guarda el hash (SHA-256) junto con su sal.
data class User(
    val id: Int = 0,
    val nombre: String,
    val usuario: String,
    val passwordHash: String,
    val salt: String,
    val rol: Rol
)
