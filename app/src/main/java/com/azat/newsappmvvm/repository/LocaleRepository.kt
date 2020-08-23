package com.azat.newsappmvvm.repository

import com.azat.newsappmvvm.db.ArticleDao
import com.azat.newsappmvvm.model.Article

import javax.inject.Inject

/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 23/08/2020 - 1:01 PM  *
 ************************/
class LocaleRepository @Inject constructor(
    val db: ArticleDao
) : BaseRepository() {

    suspend fun insertNewsToDb(article: Article) = db.insertArticle(article)

    suspend fun deleteNews(article: Article) = db.deleteArticle(article)

    fun getSavedNews() = db.getSavedArticles()
}