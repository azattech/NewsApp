package com.example.newsapp.view.adapter

import com.example.newsapp.R
import com.example.newsapp.base.BaseRecyclerViewAdapter
import com.example.newsapp.base.BaseViewHolder
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.model.Articles


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 04/03/2020 - 9:14 PM  *
 ************************/
class NewsListAdapter : BaseRecyclerViewAdapter<ItemNewsBinding, Articles>() {

    override fun getLayout() = R.layout.item_news

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemNewsBinding>,
        position: Int
    ) {
        holder.binding.articles = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(it, items[position], position)
        }
    }
}