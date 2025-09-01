package com.example.crud.data.remote

import com.example.crud.data.model.Dress
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("users")
    suspend fun getDress(): Response<List<Dress>>

    @POST("dress")
    suspend fun createDress(@Body dress: Dress): Response<Dress>

    @DELETE("/dress/{id}")
    suspend fun deleteDress(@Path("id") id: String)
}