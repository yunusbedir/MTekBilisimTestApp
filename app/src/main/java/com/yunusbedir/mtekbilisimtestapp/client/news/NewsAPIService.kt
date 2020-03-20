package com.yunusbedir.mtekbilisimtestapp.client.news

import com.yunusbedir.mtekbilisimtestapp.model.RSSBaseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by YUNUS BEDİR on 20.03.2020.
 */
interface NewsAPIService {

    @GET("/v1/api.json")
    fun getNews(
        @Query("rss_url") rss_url: String
    ): Call<RSSBaseModel>
}