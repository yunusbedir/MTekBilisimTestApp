package com.yunusbedir.mtekbilisimtestapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PharmacyBaseModel(

    @SerializedName("success")
    @Expose
    var success : Boolean? = false,
    @SerializedName("result")
    @Expose
    var result : List<Result?>? = null
)