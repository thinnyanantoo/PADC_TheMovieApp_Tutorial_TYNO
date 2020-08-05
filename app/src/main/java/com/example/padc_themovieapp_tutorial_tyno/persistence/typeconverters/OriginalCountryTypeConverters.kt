package com.example.padc_themovieapp_tutorial_tyno.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OriginalCountryTypeConverters {

    @TypeConverter
    fun toList(jsonString: String): ArrayList<String> {
        return Gson().fromJson(jsonString, object : TypeToken<ArrayList<String>>() {}.type)
    }

    @TypeConverter
    fun toJsonString(list: ArrayList<String>): String {
        return Gson().toJson(list)
    }
}