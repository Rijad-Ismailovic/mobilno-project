package com.example.sportfieldreservationapp.data

import com.example.sportfieldreservationapp.R
import com.example.sportfieldreservationapp.model.Field

class Datasource {
    fun loadCards(): List<Field>{
        return listOf<Field>(
            Field(R.string.iusballon_title, R.string.iusballon_sport, R.string.iusballon_city, R.string.iusballon_price, R.string.iusballon_time, R.drawable.iusballon),
            Field(R.string.bentbasa_title, R.string.bentbasa_sport, R.string.bentbasa_city, R.string.bentbasa_price, R.string.bentbasa_time, R.drawable.bentbasa),
        )
    }
}