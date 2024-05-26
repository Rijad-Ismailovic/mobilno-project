package com.example.sportfieldreservationapp.model.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "fields")
data class Fields(
    @PrimaryKey
    @NotNull
    val id: Int = 0,
    val title: String,
    val sport: String,
    val city: String,
    val price: Double,
    val time: String,
    val imagePath: String
)