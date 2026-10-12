package com.example.sistemaasistenciaempleados.controller

import com.example.sistemaasistenciaempleados.api.RetrofitClient
import com.example.sistemaasistenciaempleados.model.Usuario

class UsuarioController {

    private val api = RetrofitClient.apiService

    // Función para obtener la lista de usuarios
    suspend fun obtenerUsuarios(): List<Usuario>? {
        return try {
            val response = api.obtenerUsuarios()
            if (response.isSuccessful) {
                response.body()
            } else {
                null // O manejar el error según necesites
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    // Función para validar el inicio de sesión
    suspend fun login(email: String, password: String): Usuario? {
        return try {
            val credenciales = mapOf("email" to email, "password" to password)
            val response = api.loginUsuario(credenciales)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}