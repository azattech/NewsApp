package com.example.newsapp.model

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 02/03/2020 - 10:48 PM *
 ************************/

interface NewsApiService {
    @GET("top-headlines")
    fun getNewsAsync(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?
    ): Deferred<News>

    companion object {

        private const val BASE_URL = "https://newsapi.org/v2/"

        fun create(): NewsApiService {
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(NewsApiService::class.java)
        }
    }
}
/* https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=8fc34d247dee40b5ba90295e691cf8b7*/