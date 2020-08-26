package com.azat.newsappmvvm.ui.fragments


import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.azat.newsappmvvm.R
import com.azat.newsappmvvm.ui.NewsAdapter
import com.azat.newsappmvvm.ui.NewsViewModel
import com.azat.newsappmvvm.util.Constant.Companion.SEARCH_NEWS_TIME_DELAY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search_news.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {

    lateinit var newsAdapter: NewsAdapter

    private val viewModel: NewsViewModel by viewModels()

    var job: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()



        etSearch.addTextChangedListener { editable ->
            job?.cancel()
            job = MainScope().launch {
                delay(SEARCH_NEWS_TIME_DELAY)
                editable?.let {
                    if (editable.toString().isNotEmpty()) {
                        viewModel.searchNews(editable.toString())
                    }
                }
            }
        }

        viewModel.searchNewsLiveData.observe(viewLifecycleOwner, Observer {
            pbSearchNews.visibility = View.VISIBLE
            newsAdapter.differ.submitList(it)
            pbSearchNews.visibility = View.GONE
            rvSearchNews.visibility = View.VISIBLE
        })
    }


    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        rvSearchNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}