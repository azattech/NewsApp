package com.example.newsapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 02/03/2020 - 10:47 PM *
 ************************/

@Parcelize
data class News(
    val status: String?,
    val totalResults: Int?,
    val articles: List<Articles>?
) : Parcelable

@Parcelize
data class Articles(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
) : Parcelable

@Parcelize
data class Source(
    val id: String?,
    val name: String?
) : Parcelable