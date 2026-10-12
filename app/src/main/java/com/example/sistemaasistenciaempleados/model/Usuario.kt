package com.example.sistemaasistenciaempleados.model

import com.google.gson.annotations.SerializedName

data class Usuario(
    val id: Int,
    val username: String,
    val email: String,
    val password: String?,
    val nombre: String,
    val apellido: String,
    val telefono: String,
    val dni: String,
    @SerializedName("fecha_nacimiento") val fechaNacimiento: String,
    @SerializedName("reset_token") val resetToken: String?,
    val activo: Int,
    @SerializedName("rol_id") val rolId: Int
)
