package com.example.padc_themovieapp_tutorial_tyno.data.vos

import androidx.room.TypeConverters
import com.example.padc_themovieapp_tutorial_tyno.persistence.typeconverters.GenereTypeConverters
import com.google.gson.annotations.SerializedName


@TypeConverters(GenereTypeConverters::class,
    OriginalCountryVO::class)
data class KnownForVO (
    @SerializedName("original_name") var originalName : String ,
    @SerializedName("vote_count")var voteCount : Int,
    @SerializedName("poster_path")var posterPath : String,
    @SerializedName("media_type")var mediaType : String,
    @SerializedName("name")var name : String,
    @SerializedName("vote_average")var voteAverage : Double,
    @SerializedName("id") var id : Int,
    @SerializedName("first_air_date") var firstAirDate : String,
    @SerializedName("original_language") var originalLanguage : String,
    @SerializedName("genre_ids") var genreIds : ArrayList<Int>,
    @SerializedName("backdrop_path") var backDropPath : String,
    @SerializedName("overview")var overview : String,
    @SerializedName("origin_country")var originCountry : ArrayList<String>,
    @SerializedName("release_date") var releaseDate : String,
    @SerializedName("video")var video : Boolean,
    @SerializedName("original_title") var originalTitle : String,
    @SerializedName("adult")var adult: Boolean,
    @SerializedName("title")var title : String
)


