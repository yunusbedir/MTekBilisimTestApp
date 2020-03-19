package com.yunusbedir.mtekbilisimtestapp.client

import com.yunusbedir.mtekbilisimtestapp.model.PharmacyBaseModel
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
interface PharmacyAPIService {

    @Headers(
        "content-type: application/json",
        "authorization: apikey 3nFj0vZEqNu9mo0bMd6uGD:6JtzC5bGa3dXH3FxBpeivw"
    )
    @GET("/health/dutyPharmacy")
    fun getPharmacyBaseModel(
        @Query("ilce") ilce: String,
        @Query("il") il: String
    ): Call<PharmacyBaseModel>

    @Headers(
        "content-type: application/json",
        "authorization: apikey 3nFj0vZEqNu9mo0bMd6uGD:6JtzC5bGa3dXH3FxBpeivw"
    )
    @GET("/health/dutyPharmacy")
    fun getPharmacyBaseModelList(
        @Query("ilce") ilce: String,
        @Query("il") il: String
    ): Call<List<PharmacyBaseModel>>
}