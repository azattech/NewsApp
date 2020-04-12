package com.example.newsapp.di

import com.example.newsapp.model.network.NewsApi
import com.example.newsapp.model.network.NewsApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 12/04/2020 - 11:00 AM *
 ************************/

@Module
class ApiModule {

    companion object {
        private val BASE_URL = "https://newsapi.org/v2/"
    }

    @Provides
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    fun provideNewsApiService(): NewsApiService {
        return NewsApiService()
    }
}