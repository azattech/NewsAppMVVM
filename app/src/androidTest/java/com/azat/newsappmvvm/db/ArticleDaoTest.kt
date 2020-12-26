package com.azat.newsappmvvm.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.azat.newsappmvvm.getOrAwaitValue
import com.azat.newsappmvvm.model.Article
import com.azat.newsappmvvm.model.Source
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 24/12/2020 - 7:37 AM  *
 ************************/

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ArticleDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ArticleDatabase
    private lateinit var dao: ArticleDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ArticleDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.getArticleDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertArticleItem() = runBlockingTest {
        val articleItem = Article(
            1,
            "author",
            "content",
            "description",
            "publishedAt",
            Source(1, "name"),
            "title",
            "url",
            "urlToImage"
        )
        dao.insertArticle(articleItem)

        val allArticleItems = dao.getSavedArticles().getOrAwaitValue()

        // assertThat(allArticleItems).contains(articleItem)
    }

    @Test
    fun deleteArticleItem() = runBlockingTest {
        val articleItem = Article(
            1,
            "author",
            "content",
            "description",
            "publishedAt",
            Source(1, "name"),
            "title",
            "url",
            "urlToImage"
        )
        dao.insertArticle(articleItem)
        dao.deleteArticle(articleItem)

        val allArticleItems = dao.getSavedArticles().getOrAwaitValue()

        assertThat(allArticleItems).doesNotContain(articleItem)
    }
}