package com.example.project.backend


import FieldsRepository
import android.content.Context
import com.example.project.backend.repositories.AdminsRepository
import com.example.project.backend.repositories.UsersRepository


interface AppContainer {
    val fieldRepository: FieldsRepository
    val usersRepository: UsersRepository
    val adminsRepository: AdminsRepository
}
class AppDataContainer(private val context: Context): AppContainer {

    override val fieldRepository: FieldsRepository by lazy {
        FieldsRepository(FieldDatabase.getDatabase(context).fieldDao())
    }

    override val usersRepository: UsersRepository by lazy {
        UsersRepository(FieldDatabase.getDatabase(context).userDao())
    }

    override val adminsRepository: AdminsRepository by lazy {
        AdminsRepository(FieldDatabase.getDatabase(context).adminDao())
    }
}