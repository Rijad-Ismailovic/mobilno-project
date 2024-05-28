package com.example.project.backend.repositories

import com.example.project.backend.models.Users
import com.example.project.backend.daos.UsersDao
import kotlinx.coroutines.flow.Flow

class UsersRepository(private val usersDao: UsersDao): BaseRepository<Users> {
    override suspend fun insert(t: Users) = usersDao.insert(t)

    override suspend fun update(t: Users) = usersDao.update(t)

    override suspend fun delete(t: Users) = usersDao.delete(t)

    override fun getOneStream(id: Int): Flow<Users?> = usersDao.getUser(id)

    fun getUsers() = usersDao.getUsers()
}