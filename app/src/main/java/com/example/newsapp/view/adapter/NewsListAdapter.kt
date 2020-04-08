package com.example.newsapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.model.Articles
import com.example.newsapp.view.fragments.NewsFragmentDirections


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 04/03/2020 - 9:14 PM  *
 ************************/
class NewsListAdapter(
    private val articlesList: ArrayList<Articles>
) : RecyclerView.Adapter<NewsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder =
        NewsListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_news,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = articlesList.size

    override fun onBindViewHolder(viewHolder: NewsListViewHolder, position: Int) {
        viewHolder.itemNewsBinding.articles = articlesList[position]
        viewHolder.itemNewsBinding.root.setOnClickListener {
            val action =
                NewsFragmentDirections.actionNewsFragmentToDetailFragment(articlesList[position])
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateNews(newArticlesList: List<Articles>) {
        articlesList.clear()
        articlesList.addAll(newArticlesList)
        notifyDataSetChanged()
    }
}