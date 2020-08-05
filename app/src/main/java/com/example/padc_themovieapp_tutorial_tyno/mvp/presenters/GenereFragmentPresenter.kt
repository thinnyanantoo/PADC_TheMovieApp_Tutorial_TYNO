package com.example.padc_themovieapp_tutorial_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieViewHolderDelegate
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.GenereFragmentView

interface GenereFragmentPresenter :BasePresenter<GenereFragmentView> , MovieViewHolderDelegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner,movieId : Int)
}