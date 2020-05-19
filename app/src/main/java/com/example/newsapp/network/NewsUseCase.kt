package com.example.newsapp.network

import com.example.newsapp.di.DaggerUseCaseComponent
import com.example.newsapp.model.Articles
import javax.inject.Inject


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 17/05/2020 - 12:36 PM *
 ************************/
class NewsUseCase {

    @Inject
    lateinit var newsApiService: NewsApiService

    init {
        DaggerUseCaseComponent.create().inject(this)
    }

    private val repository: NewsRepository =
        NewsRepository(newsApiService.api)

    suspend fun getLatestNews(country: String?, apiKey: String?): MutableList<Articles>? {
        return repository.getLatestNews(country, apiKey)
    }

}