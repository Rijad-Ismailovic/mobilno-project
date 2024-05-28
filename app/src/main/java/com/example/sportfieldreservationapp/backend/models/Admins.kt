package com.example.project.backend.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Admins")
data class Admins(
    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    val id : String,

    @ColumnInfo(name="name")
    val name : String,

    @ColumnInfo(name="surname")
    val surname : String,

    @ColumnInfo(name="adminusername")
    val adminusername : String,

    @ColumnInfo(name="email")
    val email : String,

    @ColumnInfo(name="password")
    val password : String,

    @ColumnInfo(name="isAdmin")
    val isAdmin : Boolean

)
