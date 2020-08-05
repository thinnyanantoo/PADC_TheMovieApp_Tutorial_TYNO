package com.example.padc_themovieapp_tutorial_tyno.data.vos

import com.google.gson.annotations.SerializedName

class MovieDetailVO (
    @SerializedName("adult") val adult : Boolean = false,
    @SerializedName("backdrop_path") val backDropPath : String = "",
    @SerializedName("genres") val genres: List<GenereVO> = emptyList(),
    @SerializedName("id") val id: Int = 0,
    @SerializedName("original_title") val originalTitle : String = "",
    @SerializedName("overview") val overview: String = "",
    @SerializedName("popularity") val popularity: String = "",
    @SerializedName("poster_path") val posterPath: String = "",
    @SerializedName("production_countries") val productionCountries: List<ProductionCountryVO> = emptyList(),
    @SerializedName("release_date") val releaseDate: String = "",
    @SerializedName("runtime") val runTime: Int = 0,
    @SerializedName("credits") val credits: CreditsVO = CreditsVO(),
    @SerializedName("tagline") val tagLine : String = "",
    @SerializedName("vote_average") val voteAverage: Double = 0.0,
    @SerializedName("vote_count") val voteCount : Int = 0
)

data class ProductionCountryVO (
    @SerializedName("iso_3166_1") val iso : String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("origin_country")val originCountry : String = " "
)

data class CreditsVO (
    @SerializedName("cast") val cast : List<castVO> = emptyList(),
    @SerializedName("crew") val crew: List<crewVO> = emptyList()
)

