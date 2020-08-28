package com.azat.newsappmvvm.util

/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 28/08/2020 - 7:39 AM  *
 ************************/

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}