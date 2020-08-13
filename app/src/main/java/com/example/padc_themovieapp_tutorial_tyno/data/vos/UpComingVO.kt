package com.example.padc_themovieapp_tutorial_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padc_themovieapp_tutorial_tyno.persistence.typeconverters.GenereTypeConverters
import com.google.gson.annotations.SerializedName

@TypeConverters(GenereTypeConverters::class)
@Entity(tableName = "upcoming")
data class UpComingVO (
    @SerializedName("popularity") var popularity : Double,
    @SerializedName("vote_count")var voteCount : Int,
    @SerializedName("video")var video : Boolean,
    @SerializedName("poster_path")var posterPath : String,

    @PrimaryKey
    @SerializedName("id")var id: Int,

    @SerializedName("adult")var adult : Boolean,
    @SerializedName("backdrop_path")var backdropPath : String? = "",
    @SerializedName("original_language")var originalLanguage : String,
    @SerializedName("original_title")var originalTitle : String,
    @SerializedName("genre_ids")var genreId : ArrayList<Int>,
    @SerializedName("title")var title : String,
    @SerializedName("vote_average") var voteAverage : Double,
    @SerializedName("overview")var overView : String,
    @SerializedName("release_date") var releaseData : String
)
