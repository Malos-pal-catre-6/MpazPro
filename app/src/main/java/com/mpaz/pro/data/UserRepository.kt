package com.mpaz.pro.data

import android.content.ContentValues
import android.content.Context
import com.mpaz.pro.model.Rol
import com.mpaz.pro.model.User

// Aqui estan las dos operaciones que usan las pantallas: registrar e iniciar sesion.
class UserRepository(context: Context) {

    private val helper = UserDbHelper(context.applicationContext)

    // El nombre de usuario se guarda siempre en minusculas y sin espacios en los bordes.
    private fun limpiar(usuario: String) = usuario.trim().lowercase()

    fun existeUsuario(usuario: String): Boolean {
        val db = helper.readableDatabase
        return db.rawQuery(
            "SELECT 1 FROM ${UserDbHelper.TABLA_USUARIOS} WHERE usuario = ?",
            arrayOf(limpiar(usuario))
        ).use { it.moveToFirst() }
    }

    // Devuelve true si se registro, false si el usuario ya existe.
    fun registrar(nombre: String, usuario: String, password: String, rol: Rol): Boolean {
        val usuarioLimpio = limpiar(usuario)
        if (existeUsuario(usuarioLimpio)) return false

        val sal = Security.generarSal()
        val valores = ContentValues().apply {
            put("nombre", nombre.trim())
            put("usuario", usuarioLimpio)
            put("password_hash", Security.hash(password, sal))
            put("salt", sal)
            put("rol", rol.name)
        }
        val resultado = helper.writableDatabase.insert(UserDbHelper.TABLA_USUARIOS, null, valores)
        return resultado != -1L
    }

    // Devuelve el usuario si los datos son correctos, o null si no.
    fun login(usuario: String, password: String): User? {
        val db = helper.readableDatabase
        return db.rawQuery(
            "SELECT id, nombre, usuario, password_hash, salt, rol " +
                "FROM ${UserDbHelper.TABLA_USUARIOS} WHERE usuario = ?",
            arrayOf(limpiar(usuario))
        ).use { c ->
            if (!c.moveToFirst()) return@use null

            val hashGuardado = c.getString(3)
            val sal = c.getString(4)
            if (Security.hash(password, sal) != hashGuardado) return@use null

            User(
                id = c.getInt(0),
                nombre = c.getString(1),
                usuario = c.getString(2),
                passwordHash = hashGuardado,
                salt = sal,
                rol = Rol.desdeTexto(c.getString(5))
            )
        }
    }
}
