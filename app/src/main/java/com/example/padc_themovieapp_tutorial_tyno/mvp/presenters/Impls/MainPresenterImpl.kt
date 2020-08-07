package com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.PopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.PopularMovieModel
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.MainPresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>(){

   var mPopularModel : PopularMovieModel = PopularMovieModelImpl
    override fun onSwipeRefrresh(lifecycleOwner: LifecycleOwner) {
        requestAllPopularMovies(lifecycleOwner)
        requestAllBestActor(lifecycleOwner)
       requestAllGenereList(lifecycleOwner)
     //   requestAllUpComingList(lifecycleOwner)
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        requestAllPopularMovies(lifecycleOwner)
        requestAllBestActor(lifecycleOwner)
      requestAllGenereList(lifecycleOwner)
       // requestAllUpComingList(lifecycleOwner)
    }

    override fun onTapPlay(movieId: Int) {
        mView?.navigateToPlayerView(movieId)
    }
    override fun onTapMovie(movieId : Int) {
        mView?.navigateToSecondView(movieId)
    }

    private fun requestAllPopularMovies(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        mPopularModel.getAllPopularMovie (onError = {
            mView?.disableSwipeRefresh()
            mView?.displayEmptyView()
        }).observe(lifecycleOwner, Observer{
            mView?.disableSwipeRefresh()
            if(it.isEmpty())
                mView?.displayEmptyView()
            else
                mView?.displayPopularMovieList(it)
        })
     }

    private fun requestAllBestActor(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        mPopularModel.getAllActors ( onError = {
            mView?.disableSwipeRefresh()
            mView?.displayEmptyView()
        }).observe(lifecycleOwner, Observer {
            mView?.disableSwipeRefresh()
            if(it.isEmpty())
                mView?.displayEmptyView()
            else
                mView?.displayBestActorList(it)
        }
        )
    }

    private fun requestAllGenereList(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        mPopularModel.getAllGenere (onError = {
            mView?.disableSwipeRefresh()
            mView?.displayEmptyView()
        }).observe(lifecycleOwner, Observer{
            mView?.disableSwipeRefresh()
            if(it.isEmpty())
                mView?.displayEmptyView()
            else
                mView?.displayGenereList(it)
        })
    }

//    private fun requestAllTabList(lifecycleOwner: LifecycleOwner){
//        mView?.enableSwipeRefresh()
//        mPopularModel.getAllList( onError = {
//            mView?.disableSwipeRefresh()
//            mView?.displayEmptyView()
//        }).observe(lifecycleOwner,Observer {
//            mView?.disableSwipeRefresh()
//            if(it.isEmpty())
//                mView?.displayEmptyView()
//            else
//                mView?.displayMovieListInTab(it)
//        })

  //  }
//    private fun requestAllUpComingList(lifecycleOwner: LifecycleOwner){
//        mView?.enableSwipeRefresh()
//        mPopularModel.getAllUpComing (onError = {
//            mView?.disableSwipeRefresh()
//            mView?.displayEmptyView()
//        }).observe(lifecycleOwner, Observer {
//            mView?.disableSwipeRefresh()
//            if(it.isEmpty())
//                mView?.displayEmptyView()
//            else
//                mView?.displayUpComingMovie(it)
//        })
//    }
}