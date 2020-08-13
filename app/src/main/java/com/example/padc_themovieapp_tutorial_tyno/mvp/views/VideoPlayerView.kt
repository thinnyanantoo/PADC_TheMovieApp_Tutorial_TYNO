package com.example.padc_themovieapp_tutorial_tyno.mvp.views

import com.example.shared.mvp.views.BaseView

interface VideoPlayerView : BaseView {
    fun showVideo(key : String)
}