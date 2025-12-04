package com.fauziyah252.harrypotterbooks

import com.fauziyah252.harrypotterapp.Book
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("en/books")
    suspend fun getBooks(): List<Book>
}

object RetrofitClient {
    private const val BASE_URL = "https://potterapi-fedeperin.vercel.app/"

    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}