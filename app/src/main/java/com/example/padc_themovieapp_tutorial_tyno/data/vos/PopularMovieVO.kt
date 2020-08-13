package com.example.padc_themovieapp_tutorial_tyno.data.vos

import androidx.room.*
import com.example.padc_themovieapp_tutorial_tyno.persistence.typeconverters.GenereTypeConverters
import com.google.gson.annotations.SerializedName

@TypeConverters(GenereTypeConverters::class)
@Entity(tableName = "popularmovies")
data class PopularMovieVO (
        @SerializedName("popularity") var popularity : Double = 0.0,
        @SerializedName("vote_count") var voteCount : Int = 0,
        @SerializedName("video") var video : Boolean = true,
        @SerializedName("poster_path")var posterPath : String = "",

        @PrimaryKey
        @SerializedName("id") var id : Int = 0,

        @SerializedName("adult") var adult: Boolean = true,
        @SerializedName("backdrop_path") var backdropPath : String? = "",
        @SerializedName("original_language")var originalLanguage : String = "",
        @SerializedName("original_title") var originalTitle : String = "",
        @SerializedName("genre_ids") var genreIds : ArrayList<Int> = ArrayList(),
        @SerializedName("title") var title : String = "",
        @SerializedName("vote_average")var voteAverage : Double = 0.0,
        @SerializedName("overview") var overview : String = "",
        @SerializedName("release_date")var releaseDate : String = ""
    )