package com.example.sportfieldreservationapp.model

import android.content.Context
import com.example.sportfieldreservationapp.model.repositories.FieldRepository

interface AppContainer {
    val fieldRepository: FieldRepository
    //val courseRepository: CourseRepository    //riki: dodajte vase repositories
}
class AppDataContainer(private val context: Context): AppContainer{

    override val fieldRepository: FieldRepository by lazy {
        FieldRepository(FieldDatabase.getDatabase(context).fieldDao())
    }

    /*override val courseRepository: CourseRepository by lazy {                 //riki: dodajte kako se vec ovo zove ovdje
        CourseRepository(StudentDatabase.getDatabase(context).courseDao())
    }*/

}
