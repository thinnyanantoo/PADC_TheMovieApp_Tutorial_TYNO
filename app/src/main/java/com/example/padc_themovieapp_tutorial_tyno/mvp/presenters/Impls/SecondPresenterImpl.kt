package com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.PopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.SecondPresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.SecondView

class SecondPresenterImpl :SecondPresenter, AbstractBasePresenter<SecondView>(){
    private  val mPopularModel = PopularMovieModelImpl
    override fun onUiReady(movieId : Int) {
       getMovieDetail(movieId)
    }

    override fun onTapBtnTrailer() {

    }

    override fun onTapBtnRate() {

    }

      fun getMovieDetail(movieId : Int) {
          mView?.enableSwipeRefresh()
          mPopularModel.getMovieDetail(movieId, onError = {
              mView?.disableSwipeRefresh()

          }, onSuccess = {
              mView?.disableSwipeRefresh()
              mView?.showDetail(it)

          })

    }


}
