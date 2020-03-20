package com.yunusbedir.mtekbilisimtestapp.database.room

import android.content.Context
import android.os.AsyncTask
import com.yunusbedir.mtekbilisimtestapp.enums.Key
import com.yunusbedir.mtekbilisimtestapp.model.User


/**
 * Created by YUNUS BEDİR on 18.03.2020.
 */
class UserRepository(context: Context) {

    private var userDao: UserDao

    init {
        val database = MyDatabase.getInstance(context)
        userDao = database.userDao()
    }

    fun insert(user: User) {
        InsertUserAsyncTask(
            userDao
        ).execute(user)
    }

    fun update(user: User) {

        UpdateUserAsyncTask(
            userDao
        ).execute(user)
    }

    fun delete(user: User) {
        DeleteUserAsyncTask(
            userDao
        ).execute(user)
    }

    fun getUser(email: String, password: String): User? {
        return GetUserAsyncTask(
            userDao
        ).execute(
            mapOf(
                Key.EMAIL.name to email,
                Key.PASSWORD.name to password
            )
        ).get()
    }

    class InsertUserAsyncTask(private var userDao: UserDao) : AsyncTask<User, Void, Void?>() {
        override fun doInBackground(vararg params: User?): Void? {
            params[0]?.let { userDao.insert(it) }
            return null
        }
    }

    class UpdateUserAsyncTask(private var userDao: UserDao) : AsyncTask<User, Void, Void?>() {
        override fun doInBackground(vararg params: User?): Void? {
            params[0]?.let { userDao.update(it) }
            return null
        }
    }

    class DeleteUserAsyncTask(private var userDao: UserDao) : AsyncTask<User, Void, Void?>() {
        override fun doInBackground(vararg params: User?): Void? {
            params[0]?.let { userDao.delete(it) }
            return null
        }
    }

    class GetUserAsyncTask(private var userDao: UserDao) :
        AsyncTask<Map<String, String>, Void, User?>() {
        override fun doInBackground(vararg params: Map<String, String>): User? {

            val email = params[0][Key.EMAIL.name]
            val password = params[0][Key.PASSWORD.name]
            var user: User? = null
            if (email != null && password != null) {
                user = userDao.getUser(email, password)
            }
            return user
        }
    }
}