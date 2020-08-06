package com.example.padc_themovieapp_tutorial_tyno.mvp.views

import com.example.padc_themovieapp_tutorial_tyno.data.vos.*

interface MainView : BaseView{
    fun displayPopularMovieList(movieList : List<PopularMovieVO>)
    fun displayBestActorList(actorList : List<BestActorVO>)
    fun displayUpComingMovie(movieList : List<UpComingVO>)
    fun navigateToSecondView(movieId : Int)
    fun navigateToPlayerView(movieId: Int)
    fun displayGenereList(generes : List<GenereVO>)
}