package com.example.project.backend.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.project.backend.models.Fields
import kotlinx.coroutines.flow.Flow

@Dao
interface FieldsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(field: Fields)


    @Update
    suspend fun update(fields: Fields)


    @Delete
    suspend fun delete(fields: Fields)


    @Query("SELECT * FROM Fields WHERE id = :id")
    fun getField(id: Int): Flow<Fields>


    @Query("SELECT * FROM Fields")
    fun getFields(): Flow<List<Fields>>

}