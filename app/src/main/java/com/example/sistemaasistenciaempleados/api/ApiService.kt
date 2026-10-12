package com.example.sistemaasistenciaempleados.api

import com.example.sistemaasistenciaempleados.model.Usuario
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("api/usuarios")
    suspend fun obtenerUsuarios(): Response<List<Usuario>>

    @POST("api/login")
    suspend fun loginUsuario(@Body credenciales: Map<String, String>): Response<Usuario>
}