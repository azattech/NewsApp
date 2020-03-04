package com.example.newsapp.extensions

import java.text.SimpleDateFormat
import java.util.*


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 04/03/2020 - 9:43 PM  *
 ************************/

fun Date.formatToServerDateTimeDefaults(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return sdf.format(this)
}