package com.example.newsapp.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.model.Articles
import com.example.newsapp.model.News


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 04/03/2020 - 9:14 PM  *
 ************************/
class NewsListAdapter(private val articlesList: List<Articles>) :
    RecyclerView.Adapter<NewsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder =
        NewsListViewHolder(parent)

    override fun getItemCount(): Int = articlesList.size

    override fun onBindViewHolder(viewHolder: NewsListViewHolder, position: Int) {
        viewHolder.bind(articlesList[position])
    }

    fun updateNews(newsList: List<News>) {
        //newsList.clear()
        //newsList.addAll(newAnimalList)
        notifyDataSetChanged()
    }
}