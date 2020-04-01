package com.example.newsapp.model


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 02/03/2020 - 10:47 PM *
 ************************/

data class News(
    val status: String?,
    val totalResults: Int?,
    val articles: List<Articles>?
)

data class Articles(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)


data class Source(
    val id: String?,
    val name: String?
)