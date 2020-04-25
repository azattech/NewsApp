package com.example.newsapp.view.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.model.Articles
import com.example.newsapp.view.adapter.NewsListAdapter
import com.example.newsapp.viewmodel.NewsViewModel

class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>() {

    private val newsListAdapter by lazy {
        NewsListAdapter()
    }

    private val newsListDataObserver = Observer<List<Articles>> { list ->
        list?.let {
            binding.recyclerNewsList.visibility = View.VISIBLE
            newsListAdapter.addItems(it)
        }
    }

    private val loadingLiveDataObserver = Observer<Boolean> { isLoading ->
        binding.progressLoadingView.visibility = if (isLoading) View.VISIBLE else View.GONE
        if (isLoading) {
            binding.textNewsError.visibility = View.GONE
            binding.recyclerNewsList.visibility = View.GONE
        }
    }

    private val errorLiveDataObserver = Observer<Boolean> { isError ->
        binding.textNewsError.visibility = if (isError) View.VISIBLE else View.GONE
    }

    override fun getFragmentView() = R.layout.fragment_news

    override fun getViewModel() = NewsViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel()
        uiOperation()
    }

    private fun observeViewModel() {
        viewModel.newsLiveData.observe(this, newsListDataObserver)
        viewModel.loading.observe(this, loadingLiveDataObserver)
        viewModel.loadError.observe(this, errorLiveDataObserver)
        viewModel.refresh()
    }

    private fun uiOperation() {
        binding.recyclerNewsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsListAdapter
        }

        binding.refreshLayout.setOnRefreshListener {
            binding.apply {
                recyclerNewsList.visibility = View.GONE
                textNewsError.visibility = View.GONE
                progressLoadingView.visibility = View.VISIBLE
                viewModel.refresh()
                refreshLayout.isRefreshing = false
            }
        }

        newsListAdapter.listener = { view, item, position ->
            val action =
                NewsFragmentDirections.actionNewsFragmentToDetailFragment(item)
            Navigation.findNavController(view).navigate(action)

        }
    }
}
