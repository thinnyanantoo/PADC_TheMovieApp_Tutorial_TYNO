package com.example.padc_themovieapp_tutorial_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieTabDelegate
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieViewHolderDelegate
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.MainView
import com.example.shared.mvp.presenter.BasePresenter

interface MainPresenter : BasePresenter<MainView>, MovieViewHolderDelegate, MovieTabDelegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner)

    fun onSwipeRefrresh(lifecycleOwner: LifecycleOwner)


}