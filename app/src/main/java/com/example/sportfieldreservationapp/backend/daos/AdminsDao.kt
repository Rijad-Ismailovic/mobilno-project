package com.example.project.backend.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.project.backend.models.Admins
import kotlinx.coroutines.flow.Flow

@Dao
interface AdminsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(admin : Admins)

    @Update
    suspend fun update(admins : Admins)

    @Delete
    suspend fun delete(admins : Admins)

    @Query("SELECT * FROM Admins WHERE id = :id")
    fun getAdmin(id: Int): Flow<Admins>

    @Query("SELECT * FROM Admins")
    fun getAdmins(): Flow<List<Admins>>
}