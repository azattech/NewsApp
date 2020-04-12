package com.example.newsapp.model


import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 02/03/2020 - 10:48 PM *
 ************************/

interface NewsApi {
    @GET("top-headlines")
    fun getNewsAsync(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?
    ): Deferred<News>
}