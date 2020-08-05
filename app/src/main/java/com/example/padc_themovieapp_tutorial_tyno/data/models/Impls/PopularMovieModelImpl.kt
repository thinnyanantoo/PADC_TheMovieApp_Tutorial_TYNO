package com.example.padc_themovieapp_tutorial_tyno.data.models.Impls

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.padc_themovieapp_tutorial_tyno.data.models.BaseModel
import com.example.padc_themovieapp_tutorial_tyno.data.models.PopularMovieModel
import com.example.padc_themovieapp_tutorial_tyno.data.vos.*
import com.example.padc_themovieapp_tutorial_tyno.utiils.API_VALUE
import com.example.padc_themovieapp_tutorial_tyno.utiils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PopularMovieModelImpl : PopularMovieModel, BaseModel() {
    override fun getAllUpComing(onError: (String) -> Unit): LiveData<List<UpComingVO>> {
        return mTheDB.UpComingMovieDao().getAllUpComings()
    }

    @SuppressLint("checkResult")
    override fun getAllUpComingFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
       mApi
           .getAllUpComing(API_VALUE)
           .map{ it.results?.toList() ?: listOf()}
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
               mTheDB.UpComingMovieDao().insertAllUpComings(it)
           },{
               Log.e("error",it.localizedMessage)
               onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
           })
    }

//    override fun getAllList(onError: (String) -> Unit): LiveData<List<TabListVO>> {
//        return mTheDB.TabListDao().getAllTabList()
//    }

//    @SuppressLint("checkResult")
//    override fun getAllListFromApiAndSaveToDatabase(
//        onSuccess: () -> Unit,
//        onError: (String) -> Unit
//    ) {
//        mApi.getAllTabList(API_VALUE)
//            .map { it.results?.toList() ?: listOf() }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                mTheDB.TabListDao().insertAllTabListMovies(it)
//            },{
//                Log.e("error",it.localizedMessage)
//                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
//            })
//    }

    override fun getAllActors(onError: (String) -> Unit): LiveData<List<BestActorVO>> {
        return mTheDB.ActorDao().getAllBestActors()
    }

    @SuppressLint("CheckResult")
    override fun getAllActorsFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi
            .getAllActors(API_VALUE)
            .map {it.actorResults?.toList() ?: listOf()}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                   mTheDB.ActorDao().insertAllActors(it)
            },{
                Log.e("error", it.localizedMessage)
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllPopularMovie(onError: (String) -> Unit): LiveData<List<PopularMovieVO>> {
        return mTheDB.PopularDao().getAllPopularMovies()
    }

    override fun getPopularMoviesById(movieId: Int): LiveData<PopularMovieVO> {
        return mTheDB.PopularDao().getPopularMovieById(movieId)
    }


    @SuppressLint("CheckResult")
    override fun getAllPopularMovieFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi
            .getAllPopularMovies(API_VALUE)
            .map {it.results?.toList() ?: listOf()}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.PopularDao().insertAllPopularMovies(it)
            }, {
                Log.e("error", it.localizedMessage)
                onError(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")
    override fun getMovieDetail(
        movieId: Int,
        onSuccess: (movie: MovieDetailVO) -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.getMovieDetail(movieId, API_VALUE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onSuccess(it)}, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")

    override fun getVideo(
        movieId: Int,
        onSuccess: (movies: VideoVO) -> Unit,
        onError: (String) -> Unit
    ) {

        mApi.getVideo(movieId, API_VALUE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(it.videoResult[0])
    },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            }
            )}

    override fun getAllGenere(onError: (String) -> Unit): LiveData<List<GenereVO>> {
        return mTheDB.GenereDao().getAllGeneres()
    }


    @SuppressLint("CheckResult")
    override fun getAllGenereFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.getGenereList(API_VALUE)
            .map { it?.genres.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.GenereDao().insertAllGenere(it)
            }, {
                Log.e("error", it.localizedMessage)
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")
    override fun getMovieByGenere(
        genereId: Int,
        onSuccess: (movies: List<PopularMovieVO>) -> Unit,
        onError: (String) -> Unit
    ) {
       mApi.getMovieByGenre(API_VALUE, genereId)
           .map{it?.results?.toList() ?: listOf()}
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
               onSuccess(it)
           }, {
               onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
           })
    }
}
