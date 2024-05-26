package com.example.sportfieldreservationapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sportfieldreservationapp.model.daos.FieldsDao
import com.example.sportfieldreservationapp.model.models.Fields

@Database(entities = [Fields::class], version = 1, exportSchema = false)    //riki: ovdje unutar [] dodajte i vase klase. Example: [Students::class, Courses::class, Grades::class]
abstract class FieldDatabase: RoomDatabase() {
    abstract fun fieldDao(): FieldsDao
    //abstract fun courseDao(): CoursesDao  //riki: dodajte svoje daos ovdje

    companion object{
        @Volatile
        private var Instance: FieldDatabase? = null

        fun getDatabase(context: Context): FieldDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, FieldDatabase::class.java, "FieldDatabase")
                    .build().also { Instance = it }
            }
        }

    }
}