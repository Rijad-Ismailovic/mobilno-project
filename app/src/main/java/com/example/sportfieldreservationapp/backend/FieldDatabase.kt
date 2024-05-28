package com.example.project.backend

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project.backend.models.Admins
import com.example.project.backend.daos.AdminsDao
import com.example.project.backend.models.Fields
import com.example.project.backend.daos.FieldsDao
import com.example.project.backend.models.Users
import com.example.project.backend.daos.UsersDao

@Database(entities = [Fields::class, Users::class, Admins::class], version = 1, exportSchema = false)
abstract class FieldDatabase: RoomDatabase() {
    abstract fun fieldDao(): FieldsDao
    abstract fun userDao(): UsersDao
    abstract fun adminDao(): AdminsDao


    companion object{
        @Volatile
        private var Instance: FieldDatabase? = null


        fun getDatabase(context: Context): FieldDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, FieldDatabase::class.java, "FieldAppDatabase")
                    .build().also { Instance = it }
            }
        }


    }
}
