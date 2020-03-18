package com.yunusbedir.mtekbilisimtestapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yunusbedir.mtekbilisimtestapp.model.User


/**
 * Created by YUNUS BEDİR on 18.03.2020.
 */
@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    companion object {
        private lateinit var INSTANCE: MyDatabase

        fun getInstance(context: Context): MyDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(MyDatabase::class) {
                    if (!::INSTANCE.isInitialized) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            MyDatabase::class.java,
                            "my_database"
                        ).fallbackToDestructiveMigration().build()
                    }

                }
            }
            return INSTANCE
        }
    }

    abstract fun userDao(): UserDao
}