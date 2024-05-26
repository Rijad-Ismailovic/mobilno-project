package com.example.sportfieldreservationapp.model.repositories

import com.example.sportfieldreservationapp.model.daos.FieldsDao
import com.example.sportfieldreservationapp.model.models.Fields
import kotlinx.coroutines.flow.Flow

class FieldRepository(private val fieldsDao: FieldsDao): BaseRepository<Fields> {
    override suspend fun insert(t: Fields) = fieldsDao.insert(t)

    override suspend fun update(t: Fields) = fieldsDao.update(t)

    override suspend fun delete(t: Fields) = fieldsDao.delete(t)

    override fun getOneStream(id: Int): Flow<Fields?> = fieldsDao.getField(id)

    fun getCourses(): Flow<List<Fields>> = fieldsDao.getAllFields()
}