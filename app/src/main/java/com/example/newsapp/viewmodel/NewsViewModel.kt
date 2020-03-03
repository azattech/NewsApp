package com.example.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.News


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 03/03/2020 - 9:34 PM  *
 ************************/
class NewsViewModel : ViewModel() {

    val news by lazy { MutableLiveData<List<News>>() }
    val loadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }


    fun refresh() {
        getAnimals()
    }

    private fun getAnimals() {


    }
}