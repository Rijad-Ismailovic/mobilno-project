package com.example.project.backend.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "Fields")
data class Fields(
    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    val id : Int = 0,

    @ColumnInfo(name="fieldName")
    val fieldName : String,

    @ColumnInfo(name="fieldType")
    val fieldType : String,

    @ColumnInfo(name="isAvailable")
    val isAvailable : Boolean,

    @ColumnInfo(name="price")
    val price : Double,

)