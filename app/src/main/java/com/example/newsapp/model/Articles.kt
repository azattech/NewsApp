package com.example.newsapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 19/05/2020 - 12:04 PM *
 ************************/
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
