package com.example.padc_themovieapp_tutorial_tyno.network.responses

import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.google.gson.annotations.SerializedName

data class GetAllPopularMovieResponse (
    @SerializedName("page") val page : Int = 0,
    @SerializedName("total_results")val totalResults : Int = 0,
    @SerializedName("total_pages") val totalPages : Int = 0,
    @SerializedName("results") val results: ArrayList<PopularMovieVO>? = null )

