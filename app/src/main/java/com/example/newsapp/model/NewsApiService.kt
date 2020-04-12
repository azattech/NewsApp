package com.example.newsapp.model

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 02/03/2020 - 10:48 PM *
 ************************/

class NewsApiService {

    /*    @Inject
      lateinit var api: NewsApi

      init {
         DaggerApiComponent.create().inject(this)
      }
   */
    companion object {
        private val BASE_URL = "https://newsapi.org/v2/"
    }

    fun provideNewsApi(): NewsApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit.create(NewsApi::class.java)
    }
}

