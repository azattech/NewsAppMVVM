package com.azat.newsappmvvm.model

/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 22/08/2020 - 6:26 PM  *
 ************************/
data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)