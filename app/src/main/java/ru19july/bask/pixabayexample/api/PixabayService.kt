package ru19july.bask.pixabayexampl.api

import ru19july.bask.pixabayexampl.api.data.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayService {

    @GET("/api")
    suspend fun search(@Query("key") apiKey: String, @Query("q") query: String): SearchResponse
}