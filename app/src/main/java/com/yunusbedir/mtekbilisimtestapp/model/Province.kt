package com.yunusbedir.mtekbilisimtestapp.model

import com.yunusbedir.mtekbilisimtestapp.enums.SpinnerType


/**
 * Created by YUNUS BEDİR on 14.03.2020.
 */
data class Province(
    override var title: String,
    var countryID: Int,
    override var mID: Int,
    override var type: Int = SpinnerType.PROVINCE.id

) : SpinnerBaseModel {
    override fun toString(): String {
        return "$title,$countryID,$mID"
    }
}