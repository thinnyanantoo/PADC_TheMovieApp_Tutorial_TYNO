package com.example.padc_themovieapp_tutorial_tyno.data.models

import androidx.lifecycle.LiveData
import com.example.padc_themovieapp_tutorial_tyno.data.vos.*

interface PopularMovieModel {
    fun getAllPopularMovie(onError : (String) -> Unit) : LiveData<List<PopularMovieVO>>

    fun getAllPopularMovieFromApiAndSaveToDatabase(onSuccess : () -> Unit, onError: (String) -> Unit)

    fun getPopularMoviesById(movieId : Int): LiveData<PopularMovieVO>

    fun getAllActors(onError: (String) -> Unit) : LiveData<List<BestActorVO>>

    fun getAllActorsFromApiAndSaveToDatabase(onSuccess: () -> Unit,onError: (String) -> Unit)

    fun getAllUpComing(onError : (String) -> Unit) : LiveData<List<UpComingVO>>

    fun getAllUpComingFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getMovieDetail(movieId: Int, onSuccess: (movie : MovieDetailVO) -> Unit , onError: (String) -> Unit)

    fun getVideo(movieId: Int, onSuccess: (movies: VideoVO) -> Unit, onError: (String) -> Unit)

    fun getAllGenere(onError: (String) -> Unit) : LiveData<List<GenereVO>>

    fun getAllGenereFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getMovieByGenere(genereId : Int, onSuccess: (movies : List<PopularMovieVO>) -> Unit,onError: (String) -> Unit)
}