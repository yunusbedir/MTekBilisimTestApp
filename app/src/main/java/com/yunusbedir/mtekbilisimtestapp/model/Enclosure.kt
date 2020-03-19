package com.yunusbedir.mtekbilisimtestapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Enclosure(
    val link: String,
    val type: String,
    val length: Int
) : Parcelable