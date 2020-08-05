package com.example.padc_themovieapp_tutorial_tyno.mvp.views

import com.example.padc_themovieapp_tutorial_tyno.data.vos.GenereVO
import com.example.padc_themovieapp_tutorial_tyno.data.vos.MovieDetailVO
import com.example.padc_themovieapp_tutorial_tyno.data.vos.ProductionCountryVO

interface SecondView : BaseView {
    fun showDetail(movieDetailVO: MovieDetailVO)
}