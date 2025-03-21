package itmo.megaolympiada.newsapplication.api.config

import itmo.megaolympiada.newsapplication.api.NewsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsApiConfig {
    private const val BASE_URL = "https://newsapi.org/"

    const val API_KEY = "4289742a439a405dbcb5bba5e516387b"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    fun createNewsApi(): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }
}