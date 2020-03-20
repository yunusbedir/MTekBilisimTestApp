package com.yunusbedir.mtekbilisimtestapp.client.pharmacy

import com.yunusbedir.mtekbilisimtestapp.model.PharmacyBaseModel
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
interface PharmacyAPIService {

    @Headers(
        "content-type: application/json",
        "authorization: apikey 5m0aeoUaNiYczxbBDroEPa:1tcq0faAsk2MZ7rGxR7uiV"
    )
    @GET("/health/dutyPharmacy")
    fun getPharmacyBaseModel(
        @Query("ilce") ilce: String,
        @Query("il") il: String
    ): Call<PharmacyBaseModel>

}