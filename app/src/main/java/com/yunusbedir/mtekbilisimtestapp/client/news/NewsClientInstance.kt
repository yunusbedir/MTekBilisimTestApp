package com.yunusbedir.mtekbilisimtestapp.client.news

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by YUNUS BEDİR on 20.03.2020.
 */
object NewsClientInstance {


    var retrofit: Retrofit? = null
    private val BASE_URL = "https://api.rss2json.com"

    fun getInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}