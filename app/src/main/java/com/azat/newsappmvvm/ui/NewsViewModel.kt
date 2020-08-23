package com.azat.newsappmvvm.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azat.newsappmvvm.model.Article
import com.azat.newsappmvvm.repository.LocaleRepository

import com.azat.newsappmvvm.repository.RemoteRepository
import kotlinx.coroutines.launch

/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 23/08/2020 - 10:28 AM  *
 ************************/
class NewsViewModel @ViewModelInject constructor(
    val remoteRepository: RemoteRepository,
    val localeRepository: LocaleRepository
) : ViewModel() {

    val newsLiveData = MutableLiveData<MutableList<Article>>()
    val searchNewsLiveData = MutableLiveData<MutableList<Article>>()

    fun getBreakingNews() = viewModelScope.launch {
        val breakingNews = remoteRepository.getBreakingNews()
        newsLiveData.postValue(breakingNews)
    }

    fun searchNews(searchQuery: String) = viewModelScope.launch {
        val searchNews = remoteRepository.searchNews(searchQuery)
        searchNewsLiveData.postValue(searchNews)
    }

    fun saveNews(article: Article) = viewModelScope.launch {
        localeRepository.insertNewsToDb(article)
    }

    fun deleteNews(article: Article) = viewModelScope.launch {
        localeRepository.deleteNews(article)
    }

    fun getSavedNews() = localeRepository.getSavedNews()
}