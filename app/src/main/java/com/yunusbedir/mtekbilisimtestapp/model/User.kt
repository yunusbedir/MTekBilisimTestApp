package com.yunusbedir.mtekbilisimtestapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by YUNUS BEDİR on 18.03.2020.
 */
@Entity(tableName = "user_table")
data class User(
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "mobile_number")
    var mobileNumber: String,
    @ColumnInfo(name = "email")
    var eMail: String,
    @ColumnInfo(name = "password")
    var password: String,
    @ColumnInfo(name = "image_url")
    var urlImage: String,
    @PrimaryKey(autoGenerate = true)
    var ID: Int = 0
)