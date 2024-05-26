package com.example.sportfieldreservationapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Field(
    @StringRes val titleStringResourceId: Int,
    @StringRes val sportStringResourceId: Int,
    @StringRes val cityStringResourceId: Int,
    @StringRes val priceStringResourceId: Int,
    @StringRes val timeStringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
)
