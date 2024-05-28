package com.example.project.backend.repositories

import com.example.project.backend.models.Admins
import com.example.project.backend.daos.AdminsDao
import kotlinx.coroutines.flow.Flow

class AdminsRepository(private val adminsDao: AdminsDao): BaseRepository<Admins> {
    override suspend fun insert(t: Admins) = adminsDao.insert(t)

    override suspend fun update(t: Admins) = adminsDao.update(t)

    override suspend fun delete(t: Admins) = adminsDao.delete(t)

    override fun getOneStream(id: Int): Flow<Admins?> = adminsDao.getAdmin(id)

    fun getAdmins() = adminsDao.getAdmins()
}