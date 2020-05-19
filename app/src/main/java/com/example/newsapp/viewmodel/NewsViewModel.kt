package com.example.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.Articles
import com.example.newsapp.network.NewsUseCase
import com.example.newsapp.utils.Constants.Companion.API_KEY
import com.example.newsapp.utils.Constants.Companion.COUNTRY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 03/03/2020 - 9:34 PM  *
 ************************/
class NewsViewModel : ViewModel() {

    val newsLiveData by lazy { MutableLiveData<List<Articles>>() }
    val loadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    private val coroutineScope = CoroutineScope(coroutineContext)

    private val newsUseCase = NewsUseCase()

    fun refresh() {
        getNews()
    }

    private fun getNews() {
        coroutineScope.launch {
            val latestNews = newsUseCase.getLatestNews(COUNTRY, API_KEY)
            newsLiveData.postValue(latestNews)
        }
        loadError.value = false
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}