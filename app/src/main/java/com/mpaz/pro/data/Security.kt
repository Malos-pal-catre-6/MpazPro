package com.mpaz.pro.data

import java.security.MessageDigest
import java.security.SecureRandom

// Funciones para proteger las contrasenas
object Security {

    // Genera un texto aleatorio  distinto para cada usuario.
    fun generarSal(): String {
        val bytes = ByteArray(16)
        SecureRandom().nextBytes(bytes)
        return bytes.joinToString("") { "%02x".format(it) }
    }

    // Calcula el hash SHA-256
    fun hash(password: String, sal: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val bytes = digest.digest((sal + password).toByteArray(Charsets.UTF_8))
        return bytes.joinToString("") { "%02x".format(it) }
    }
}
