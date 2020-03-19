package com.yunusbedir.mtekbilisimtestapp.model

data class RSSBaseModel(
    val status: String,
    val feed: Feed,
    val items: List<Items>
)