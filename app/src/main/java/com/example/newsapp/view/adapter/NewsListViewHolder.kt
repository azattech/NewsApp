package com.example.newsapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.model.Articles


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 04/03/2020 - 9:15 PM  *
 ************************/
class NewsListViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_news,
            parent,
            false
        )
    ) {

    val newsImage: ImageView = itemView.findViewById(R.id.imageView)
    val newsTitle: TextView = itemView.findViewById(R.id.textTitle)
    val newsDescription: TextView = itemView.findViewById(R.id.textDescription)
    val newsSource: TextView = itemView.findViewById(R.id.textSource)
    val newsDate: TextView = itemView.findViewById(R.id.textDate)

    fun bind(article: Articles) {
        newsImage.setImageResource(article.urlToImage!!.toInt())
        newsTitle.text = article.title
        newsDescription.text = article.description
        newsSource.text = article.source?.name
        newsDate.text = article.publishedAt
    }
}