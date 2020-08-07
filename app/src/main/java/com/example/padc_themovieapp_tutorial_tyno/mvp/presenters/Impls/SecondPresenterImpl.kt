package com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls

import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.PopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.PopularMovieModel
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.SecondPresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.SecondView

class SecondPresenterImpl :SecondPresenter, AbstractBasePresenter<SecondView>(){
    var  mPopularModel : PopularMovieModel = PopularMovieModelImpl
    override fun onUiReady(movieId : Int) {
       getMovieDetail(movieId)
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
