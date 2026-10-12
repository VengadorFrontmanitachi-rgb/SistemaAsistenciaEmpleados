package com.example.sistemaasistenciaempleados.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // Si usas un dispositivo físico, cambia 10.0.2.2 por la IP de tu computadora (ej. 192.168.1.x)
    private const val BASE_URL = "http://10.0.2.2:3000/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}