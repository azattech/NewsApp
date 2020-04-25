package com.example.newsapp.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 25/04/2020 - 3:29 PM  *
 ************************/
class BaseViewHolder<VB : ViewDataBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)