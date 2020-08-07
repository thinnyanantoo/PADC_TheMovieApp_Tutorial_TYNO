package com.example.padc_themovieapp_tutorial_tyno.data.models.Impls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.padc_themovieapp_tutorial_tyno.data.models.PopularMovieModel
import com.example.padc_themovieapp_tutorial_tyno.data.vos.*
import com.example.padc_themovieapp_tutorial_tyno.utiils.*

object MockPopularMovieModelImpl : PopularMovieModel {
    override fun getAllPopularMovieFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getAllActorsFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
    }

    override fun getAllGenereFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
    }

    override fun getMovieDetail(
        movieId: Int,
        onSuccess: (movie: MovieDetailVO) -> Unit,
        onError: (String) -> Unit
    ) {
       onSuccess(getDummyMovieDetail(movieId))
    }

    override fun getVideo(
        movieId: Int,
        onSuccess: (movies: VideoVO) -> Unit,
        onError: (String) -> Unit
    ) {
        onSuccess(getDummyVideo(movieId))
    }

    override fun getMovieByGenere(
        genereId: Int,
        onSuccess: (movies: List<PopularMovieVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        onSuccess(getDummyPopularMovies())
    }

    override fun getPopularMoviesById(movieId: Int): LiveData<PopularMovieVO> {
        val liveData = MutableLiveData<PopularMovieVO>()
        liveData.postValue(getDummyPopularMovies().first{it.id == movieId})
        return liveData
    }

    override fun getAllPopularMovie(onError: (String) -> Unit): LiveData<List<PopularMovieVO>> {
           val liveData = MutableLiveData<List<PopularMovieVO>>()
        liveData.postValue(getDummyPopularMovies())
        return liveData
    }

    override fun getAllActors(onError: (String) -> Unit): LiveData<List<BestActorVO>> {
        val liveData = MutableLiveData<List<BestActorVO>>()
        liveData.postValue(getDummyActorList())
        return liveData
    }

    override fun getAllGenere(onError: (String) -> Unit): LiveData<List<GenereVO>> {
         val liveData = MutableLiveData<List<GenereVO>>()
        liveData.postValue(getDummyAllGenere())
        return liveData
    }

}