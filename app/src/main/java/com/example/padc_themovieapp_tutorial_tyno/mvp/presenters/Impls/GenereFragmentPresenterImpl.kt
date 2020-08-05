package com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.PopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.PopularMovieModel
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.GenereFragmentPresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.GenereFragmentView

class GenereFragmentPresenterImpl : GenereFragmentPresenter, AbstractBasePresenter<GenereFragmentView>() {
    private val mPopularModel = PopularMovieModelImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner, movieId: Int) {
        requestAllGenereList(movieId, lifecycleOwner)
       // requestAllGenereList(lifecycleOwner)
    }

    override fun onTapMovie(movieId: Int) {
        mView?.navigateDetail(movieId)
    }

    fun requestAllGenereList(movieId: Int, lifecycleOwner: LifecycleOwner) {
        mPopularModel.getMovieByGenere(movieId, onSuccess = {
            mView?.displayGenereMovieList(it.toMutableList())
        }, onError = {
            mView?.displayEmptyView()
        })
    }

//    private fun requestAllGenereList(lifecycleOwner: LifecycleOwner) {
//        mView?.enableSwipeRefresh()
//        mPopularModel.getAllGenere(onError = {
//            mView?.disableSwipeRefresh()
//            mView?.displayEmptyView()
//        }).observe(lifecycleOwner, Observer {
//            mView?.disableSwipeRefresh()
//            if (it.isEmpty())
//                mView?.displayEmptyView()
//            else
//                mView?.displayGenereList(it)
//        })
//    }
}
