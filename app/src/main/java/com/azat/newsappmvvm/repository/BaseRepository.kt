package com.azat.newsappmvvm.repository


import android.util.Log
import com.azat.newsappmvvm.util.Output
import retrofit2.Response
import java.io.IOException

/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 23/08/2020 - 10:45 AM  *
 ************************/
open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, error: String): T? {
        val result = newsApiOutput(call, error)
        var output: T? = null
        when (result) {
            is Output.Success -> output = result.output
            is Output.Error -> Log.e("Error", "The $error and the ${result.exception}")
        }
        return output
    }

    private suspend fun <T : Any> newsApiOutput(
        call: suspend () -> Response<T>,
        error: String
    ): Output<T> {
        val response = call.invoke()
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return@newsApiOutput Output.Success(resultResponse)
            }
        }
        return Output.Error(IOException("OOps .. Something went wrong due to  $error"))
    }
}