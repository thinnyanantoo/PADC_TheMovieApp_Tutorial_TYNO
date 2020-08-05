package com.example.padc_themovieapp_tutorial_tyno.network.responses

import com.example.padc_themovieapp_tutorial_tyno.data.vos.UpComingVO
import com.google.gson.annotations.SerializedName

data class GetAllUpComingResponse (
    @SerializedName("results") var results : ArrayList<UpComingVO>? = null
)