package com.example.padc_themovieapp_tutorial_tyno.mvp.presenters

import com.example.padc_themovieapp_tutorial_tyno.mvp.views.BaseView

interface BasePresenter<T : BaseView> {
    fun initPresenter(view : T)
}