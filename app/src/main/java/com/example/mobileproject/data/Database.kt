package com.example.mobileproject.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Field::class],
    version = 1,
    exportSchema = false
)
abstract class Database: RoomDatabase() {
    abstract val dao: FieldDao
}