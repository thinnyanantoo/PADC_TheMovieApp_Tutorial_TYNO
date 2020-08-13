package com.example.padc_themovieapp_tutorial_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.VideoPlayerView
import com.example.shared.mvp.presenter.BasePresenter

interface VideoPlayerPresenter : BasePresenter<VideoPlayerView> {
  fun  onUiReady(movieId : Int)
}