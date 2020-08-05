package com.example.padc_themovieapp_tutorial_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padc_themovieapp_tutorial_tyno.persistence.typeconverters.KnownForTypeConverters
import com.google.gson.annotations.SerializedName

@TypeConverters(KnownForTypeConverters::class)
@Entity(tableName = "bestactor")
data class BestActorVO (

    @SerializedName("popularity") var popularity : Double,
    @SerializedName("known_for_department")var knowForDepartment : String,
    @SerializedName("gender") var gender : Int,

    @PrimaryKey
    @SerializedName("id")var id : Int,

    @SerializedName("profile_path") var profilePath : String,
    @SerializedName("adult")var adult : Boolean,
    @SerializedName("known_for")var knownFor : ArrayList<KnownForVO>,
    @SerializedName("name")var name : String

    )
