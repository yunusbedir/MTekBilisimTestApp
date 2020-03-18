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
    val name: String,
    @ColumnInfo(name = "mobile_number")
    val mobileNumber: String,
    @ColumnInfo(name = "email")
    val eMail: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "image_url")
    val urlImage: String,
    @PrimaryKey(autoGenerate = true)
    val ID: Int
)