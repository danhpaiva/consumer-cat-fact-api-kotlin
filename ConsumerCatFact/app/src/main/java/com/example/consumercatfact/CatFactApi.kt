package com.example.consumercatfact

import com.example.consumercatfact.models.Fato
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CatFactApi {
    @GET("{fact}")
    suspend fun getFato(@Path("fact") fact: String) : Response<Fato>
}