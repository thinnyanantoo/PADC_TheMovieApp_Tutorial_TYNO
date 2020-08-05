package com.example.padc_themovieapp_tutorial_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "generestable")
class GenereVO (
    @PrimaryKey
    @SerializedName("id") var id : Int,
    @SerializedName("name")var name : String
)