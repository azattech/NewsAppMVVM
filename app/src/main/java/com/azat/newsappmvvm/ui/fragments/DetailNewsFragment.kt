package com.azat.newsappmvvm.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.azat.newsappmvvm.R
import com.azat.newsappmvvm.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail_news.*


@AndroidEntryPoint
class DetailNewsFragment : Fragment(R.layout.fragment_detail_news) {

    private val viewModel: NewsViewModel by viewModels()
    private val args: DetailNewsFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            article.url?.let {
                loadUrl(it)
            }
        }

        fab.setOnClickListener {
            viewModel.saveNews(article)
            Snackbar.make(view, "News saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}