package com.yunusbedir.mtekbilisimtestapp.client.pharmacy

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */

object PharmacyClientInstance {

    var retrofit: Retrofit? = null
    val BASE_URL = "https://api.collectapi.com"

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