package com.example.padc_themovieapp_tutorial_tyno.mvp.views

import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.shared.mvp.views.BaseView


interface GenereFragmentView : BaseView {
    fun navigateDetail(movieId : Int)
    fun displayGenereMovieList(movies : List<PopularMovieVO>)
   // fun displayGenereList(generes : List<GenereVO>)

}

