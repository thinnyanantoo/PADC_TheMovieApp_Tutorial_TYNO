package com.example.padc_themovieapp_tutorial_tyno.data.vos

import com.google.gson.annotations.SerializedName

data class crewVO (
    @SerializedName("credit_id") var creditID : String,
    @SerializedName("department")var department : String,
    @SerializedName("gender")var gender: Int,
    @SerializedName("id")var id : Int,
    @SerializedName("job")var job : String,
    @SerializedName("name")var name : String,
    @SerializedName("profile_path")var profilePath : String
)