package com.example.newsapp.model.network

import com.example.newsapp.di.DaggerApiComponent
import javax.inject.Inject


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 02/03/2020 - 10:48 PM *
 ************************/

class NewsApiService {

    @Inject
      lateinit var api: NewsApi

      init {
         DaggerApiComponent.create().inject(this)
      }

    /* fun provideNewsApi(): NewsApi {
         return Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(MoshiConverterFactory.create())
             .addCallAdapterFactory(CoroutineCallAdapterFactory())
             .build()
             .create(NewsApi::class.java)
     }*/
}

