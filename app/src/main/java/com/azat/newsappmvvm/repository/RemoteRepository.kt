package com.azat.newsappmvvm.repository

import com.azat.newsappmvvm.model.Article
import com.azat.newsappmvvm.network.NewsApi
import javax.inject.Inject

/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 23/08/2020 - 11:51 AM  *
 ************************/
class RemoteRepository @Inject constructor(
    private val newsApi: NewsApi
) : BaseRepository() {

    suspend fun getBreakingNews(): MutableList<Article>? {
        return safeApiCall(
            call = { newsApi.getBreakingNews() },
            error = "Error fetching news"
        )?.articles?.toMutableList()
    }

    suspend fun searchNews(searchQuery: String): MutableList<Article>? {
        return safeApiCall(
            call = { newsApi.searchForNews(searchQuery) },
            error = "Error fetching news"
        )?.articles?.toMutableList()
    }
}