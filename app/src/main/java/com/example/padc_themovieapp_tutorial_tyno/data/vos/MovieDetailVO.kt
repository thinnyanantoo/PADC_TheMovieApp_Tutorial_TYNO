package com.example.padc_themovieapp_tutorial_tyno.data.vos

import com.google.gson.annotations.SerializedName

class MovieDetailVO (
    @SerializedName("adult") var adult : Boolean = false,
    @SerializedName("backdrop_path") var backDropPath : String = "",
    @SerializedName("genres") var genres: List<GenereVO> = emptyList(),
    @SerializedName("id") var id: Int = 0,
    @SerializedName("original_title") var originalTitle : String = "",
    @SerializedName("overview") var overview: String = "",
    @SerializedName("popularity") var popularity: String = "",
    @SerializedName("poster_path") var posterPath: String = "",
    @SerializedName("production_countries") var productionCountries: List<ProductionCountryVO> = emptyList(),
    @SerializedName("release_date") var releaseDate: String = "",
    @SerializedName("runtime") var runTime: Int = 0,
    @SerializedName("credits") var credits: CreditsVO = CreditsVO(),
    @SerializedName("tagline") var tagLine : String = "",
    @SerializedName("vote_average") var voteAverage: Double = 0.0,
    @SerializedName("vote_count") var voteCount : Int = 0
)

data class ProductionCountryVO (
    @SerializedName("iso_3166_1") var iso : String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("origin_country")var originCountry : String = " "
)

data class CreditsVO (
    @SerializedName("cast") var cast : List<castVO> = emptyList(),
    @SerializedName("crew") var crew: List<crewVO> = emptyList()
)

