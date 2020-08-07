package com.example.padc_themovieapp_tutorial_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padc_themovieapp_tutorial_tyno.data.vos.MovieDetailVO
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieTabDelegate
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieViewHolderDelegate
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.SecondView

interface SecondPresenter : BasePresenter<SecondView> {
    fun onUiReady(movieId : Int)

    fun onTapBtnRate()

}