package com.example.padc_themovieapp_tutorial_tyno.network.responses

import com.example.padc_themovieapp_tutorial_tyno.data.vos.VideoVO
import com.google.gson.annotations.SerializedName

class VideoResponse (
    @SerializedName("results")var videoResult : ArrayList<VideoVO>
)