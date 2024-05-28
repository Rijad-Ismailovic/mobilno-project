package com.example.project.backend.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.project.backend.models.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: Users)


    @Update
    suspend fun update(users : Users)


    @Delete
    suspend fun delete(users : Users)


    @Query("SELECT * FROM Users WHERE id = :id")
    fun getUser(id: Int): Flow<Users>


    @Query("SELECT * FROM Users")
    fun getUsers(): Flow<List<Users>>

}