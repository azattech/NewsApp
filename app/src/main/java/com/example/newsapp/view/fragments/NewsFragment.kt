package com.example.newsapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newsapp.R
import com.example.newsapp.model.News
import com.example.newsapp.view.NewsListAdapter
import com.example.newsapp.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private val newsListAdapter = NewsListAdapter(arrayListOf())

    private val newsListDataObserver = Observer<List<News>> { list ->
        list?.let {
            recyclerNewsList.visibility = View.VISIBLE
            newsListAdapter.updateNews(it)
        }
    }

    private val loadingLiveDataObserver = Observer<Boolean> { isLoading ->
        progressLoadingView.visibility = if (isLoading) View.VISIBLE else View.GONE
        if (isLoading) {
            textNewsError.visibility = View.GONE
            recyclerNewsList.visibility = View.GONE
        }
    }

    private val errorLiveDataObserver = Observer<Boolean> { isError ->
        textNewsError.visibility = if (isError) View.VISIBLE else View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        viewModel.news.observe(this, newsListDataObserver)
        viewModel.loading.observe(this, loadingLiveDataObserver)
        viewModel.loadError.observe(this, errorLiveDataObserver)
        viewModel.refresh()

        recyclerNewsList.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = newsListAdapter
        }
    }
}
