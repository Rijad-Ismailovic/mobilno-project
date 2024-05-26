package com.example.sportfieldreservationapp.model.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.sportfieldreservationapp.model.models.Fields
import kotlinx.coroutines.flow.Flow

@Dao
interface FieldsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(fields: Fields)

    @Update
    suspend fun update(fileds: Fields)

    @Delete
    suspend fun delete(fields: Fields)

    @Query("SELECT * FROM fields WHERE id = :id")
    fun getField(id: Int): Flow<Fields>

    @Query("SELECT * FROM fields")
    fun getAllFields(): Flow<List<Fields>>
}