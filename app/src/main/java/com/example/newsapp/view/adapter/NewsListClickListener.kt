package com.example.newsapp.view.adapter

import android.view.View
import com.example.newsapp.model.Articles


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 08/04/2020 - 10:15 PM *
 ************************/
interface NewsListClickListener {

    fun onNewsListItemClick(view: View, articles: Articles)
}