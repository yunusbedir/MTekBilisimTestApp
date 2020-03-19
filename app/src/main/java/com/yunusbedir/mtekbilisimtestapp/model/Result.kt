package com.yunusbedir.mtekbilisimtestapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("name")
    @Expose
    val name : String?=null,
    @SerializedName("dist")
    @Expose
    val dist : String?=null,
    @SerializedName("address")
    @Expose
    val address : String?=null,
    @SerializedName("phone")
    @Expose
    val phone : String?=null,
    @SerializedName("loc")
    @Expose
    val loc : String?=null
)