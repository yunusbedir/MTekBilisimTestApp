package com.yunusbedir.mtekbilisimtestapp.model

import com.yunusbedir.mtekbilisimtestapp.enums.SpinnerType


/**
 * Created by YUNUS BEDİR on 14.03.2020.
 */
data class City(
    override var title: String,
    var provinceID: Int,
    override var mID: Int,
    override var type: Int = SpinnerType.CITY.id

) :SpinnerBaseModel{
    override fun toString(): String {
        return "$title,$provinceID,$mID"
    }
}