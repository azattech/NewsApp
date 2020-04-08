package com.example.newsapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentDetailBinding
import com.example.newsapp.model.Articles
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    var articles: Articles? = null
    private lateinit var dataBinding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressWebView.visibility = View.VISIBLE
        arguments?.let {
            articles = DetailFragmentArgs.fromBundle(it).articles
            progressWebView.visibility = View.VISIBLE
        }

        dataBinding.articles = articles
        initWebView()

        /*articles?.url?.let {
            initWebView()
            progressWebView.visibility = View.GONE
        }*/
    }

    private fun initWebView() {
        progressWebView.visibility = View.GONE
        webView.settings.loadsImagesAutomatically = true
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.setSupportZoom(true)
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        webView.webViewClient = object : WebViewClient() {}

    }

}
