package com.example.actividad1boris

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    // servico para consumo de api
    @GET
    suspend fun getNoticias(@Url url:String): Response<NoticiaResponse>

}