package com.example.padc_themovieapp_tutorial_tyno.network.responses

import com.example.padc_themovieapp_tutorial_tyno.data.vos.GenereVO
import com.google.gson.annotations.SerializedName

class GetGenereListResponse (
    @SerializedName("genres") val genres : List<GenereVO>
)