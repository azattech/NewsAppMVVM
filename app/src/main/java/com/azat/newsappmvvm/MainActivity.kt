package com.azat.newsappmvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.azat.newsappmvvm.db.ArticleDao
import com.azat.newsappmvvm.network.NewsApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var articleDao: ArticleDao

    @Inject
    lateinit var newsApi: NewsApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("articleDao", "ARTICLE_DAO: ${articleDao.hashCode()}")
        Log.d("newsApi", "NEWS_API: ${newsApi.hashCode()}")
    }
}