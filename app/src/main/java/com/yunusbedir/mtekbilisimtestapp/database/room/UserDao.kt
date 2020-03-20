package com.yunusbedir.mtekbilisimtestapp.database.room

import androidx.room.*
import com.yunusbedir.mtekbilisimtestapp.model.User


/**
 * Created by YUNUS BEDİR on 18.03.2020.
 */
@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user_table WHERE email = :email AND password= :password")
    fun getUser(email: String, password: String) : User?


}