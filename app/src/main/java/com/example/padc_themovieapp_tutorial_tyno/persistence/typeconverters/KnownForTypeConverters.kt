package com.example.padc_themovieapp_tutorial_tyno.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.padc_themovieapp_tutorial_tyno.data.vos.KnownForVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class KnownForTypeConverters {
    @TypeConverter
    fun toString(knownList: ArrayList<KnownForVO>): String {
        return Gson().toJson(knownList)
    }

    @TypeConverter
    fun toJsonList(knownListJsonStr: String): ArrayList<KnownForVO> {
        val knownListType = object : TypeToken<ArrayList<KnownForVO>>() {}.type
        return Gson().fromJson(knownListJsonStr, knownListType)
    }
}