package com.example.newsapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 19/05/2020 - 12:05 PM *
 ************************/
@Parcelize
data class Source(
    val id: String?,
    val name: String?
) : Parcelable