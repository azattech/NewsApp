package com.example.newsapp.network

import com.example.newsapp.model.Articles


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 01/04/2020 - 10:17 PM *
 ************************/
class NewsRepository(private val newsApi: NewsApi) {

    suspend fun getLatestNews(country: String?, apiKey: String?): MutableList<Articles>? {
        return try {
            val response = newsApi.getNewsAsync(country, apiKey)
                .await()
            response.articles?.toMutableList()
        } catch (e: Exception) {
            null
        }
    }
}