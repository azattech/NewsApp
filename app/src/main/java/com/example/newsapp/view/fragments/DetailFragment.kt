package com.example.newsapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.newsapp.R
import com.example.newsapp.model.Articles
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    var articles: Articles? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressWebView.visibility = View.VISIBLE
        arguments?.let {
            articles = DetailFragmentArgs.fromBundle(it).articles
            progressWebView.visibility = View.VISIBLE
        }

        /*   context?.let{
               img.loadImage(articles?.urlToImage, getProgressDrawable(it))
           }
           title_on_appbar.text = articles?.source.toString()
           subtitle_on_appbar.text = articles?.url
           date.text = articles?.publishedAt
           title.text = articles?.title*/
        articles?.url?.let {
            initWebView(it)
            progressWebView.visibility = View.GONE
        }
    }

    private fun initWebView(url: String) {
        webView.settings.loadsImagesAutomatically = true
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.setSupportZoom(true)
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        webView.webViewClient = object : WebViewClient() {}
        webView.loadUrl(url)
    }

}
