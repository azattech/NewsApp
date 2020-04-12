package com.example.newsapp.di


import com.example.newsapp.model.network.NewsApiService
import com.example.newsapp.model.network.NewsRepository
import dagger.Component


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 12/04/2020 -11:37 AM  *
 ************************/

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(newsApiService: NewsApiService)

    fun injectRepository(newsRepository: NewsRepository)
}