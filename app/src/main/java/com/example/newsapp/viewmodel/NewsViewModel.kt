package com.example.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.Articles
import com.example.newsapp.model.Source


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 03/03/2020 - 9:34 PM  *
 ************************/
class NewsViewModel : ViewModel() {

    val news by lazy { MutableLiveData<List<Articles>>() }
    val loadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }


    fun refresh() {
        getNews()
    }

    private fun getNews() {
        val source = Source("", "")

        val a1 = Articles(source, "", "", "", "", "", "", "")
        val a2 = Articles(source, "", "", "", "", "", "", "")
        val a3 = Articles(source, "", "", "", "", "", "", "")
        val a4 = Articles(source, "", "", "", "", "", "", "")
        val a5 = Articles(source, "", "", "", "", "", "", "")
        val a6 = Articles(source, "", "", "", "", "", "", "")
        val a7 = Articles(source, "", "", "", "", "", "", "")

        var newsList: ArrayList<Articles> = arrayListOf(a1, a2, a3, a4, a5, a6, a7)

        news.value = newsList
        loadError.value = false
        loading.value = false
    }
}