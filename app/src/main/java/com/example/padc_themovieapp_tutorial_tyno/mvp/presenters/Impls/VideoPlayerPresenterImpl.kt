package com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls

import androidx.lifecycle.LifecycleOwner
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.PopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.PopularMovieModel
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.VideoPlayerPresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.VideoPlayerView

class VideoPlayerPresenterImpl : VideoPlayerPresenter, AbstractBasePresenter<VideoPlayerView>(){
    var  mPopularModel : PopularMovieModel = PopularMovieModelImpl
    override fun onUiReady(movieId : Int) {
       getMoviewPlay(movieId)
    }

    fun getMoviewPlay(movieId: Int){
        mPopularModel.getVideo(movieId, onError = {
            mView?.disableSwipeRefresh()
            mView?.displayEmptyView()
        }, onSuccess = {
            mView?.disableSwipeRefresh()
            mView?.showVideo(it.key ?: "")

        })
    }





}