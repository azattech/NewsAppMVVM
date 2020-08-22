package com.azat.newsappmvvm.network

/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 22/08/2020 - 6:34 PM  *
 ************************/
object NewsApiService {

    //   @Inject lateinit var newsApi: NewsApi

    /* companion object {
         private val retrofit by lazy {
             val logging = HttpLoggingInterceptor()
             logging.setLevel(HttpLoggingInterceptor.Level.BODY)

             val client = OkHttpClient.Builder()
                 .addInterceptor(logging)
                 .build()

             Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .client(client)
                 .build()
         }

         val api by lazy {
             retrofit.create(NewsApi::class.java)
         }
     }*/
}