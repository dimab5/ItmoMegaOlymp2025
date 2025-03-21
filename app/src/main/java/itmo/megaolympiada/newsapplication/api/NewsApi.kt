package itmo.megaolympiada.newsapplication.api

import itmo.megaolympiada.newsapplication.api.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {
    @Headers(
        "Accept: application/json",
        "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 YaBrowser/25.2.0.0 Safari/537.36"
    )
    @GET("v2/everything")
    suspend fun getNews(
        @Query("domains") domains: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse
}