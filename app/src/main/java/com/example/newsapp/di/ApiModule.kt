package com.example.newsapp.di

import com.example.newsapp.network.NewsApi
import com.example.newsapp.network.NewsApiService
import com.example.newsapp.utils.Constants.Companion.BASE_URL
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