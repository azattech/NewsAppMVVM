package com.azat.newsappmvvm.repository

import com.azat.newsappmvvm.db.ArticleDao
import com.azat.newsappmvvm.model.Article
import com.azat.newsappmvvm.network.NewsApi
import javax.inject.Inject

/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 22/08/2020 - 8:13 PM  *
 ************************/
class MainRepository @Inject constructor(
    val articleDao: ArticleDao,
    val newsApi: NewsApi
) {

    suspend fun getBreakingNews() = newsApi.getBreakingNews()

    suspend fun searchNews(searchQuery: String) = newsApi.searchForNews(searchQuery)

    suspend fun insertNewsToDb(article: Article) = articleDao.insertArticle(article)

    suspend fun deleteNews(article: Article) = articleDao.deleteArticle(article)

    fun getSavedNews() = articleDao.getSavedArticles()
}