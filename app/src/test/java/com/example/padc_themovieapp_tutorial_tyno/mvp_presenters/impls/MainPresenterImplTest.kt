package com.example.padc_themovieapp_tutorial_tyno.mvp_presenters.impls

import android.os.Build
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4


import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.MockPopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.PopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.PopularMovieModel
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls.MainPresenterImpl
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.MainView
import com.example.padc_themovieapp_tutorial_tyno.utiils.getDummyActorList
import com.example.padc_themovieapp_tutorial_tyno.utiils.getDummyAllGenere
import com.example.padc_themovieapp_tutorial_tyno.utiils.getDummyPopularMovies
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {

    private lateinit var mPresenter : MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView : MainView

     lateinit var mPopularMovieModel : PopularMovieModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        PopularMovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mPopularMovieModel= MockPopularMovieModelImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mPopularModel = this.mPopularMovieModel
    }

    @Test
    fun onTapPlay_navigateToPlayerView(){
        val tapPlay = PopularMovieVO(1.2,1,true,"https://www.posterPath",1,false,"https://www.backdropPath","en","Harry", ArrayList(1),"Paradise"
        ,1.2,"Good Movie","12/02/2020")
        mPresenter.onTapPlay(tapPlay.id)
        verify {
            mView.navigateToPlayerView(tapPlay.id) }
    }

    @Test
    fun onTapMovie_navigateToSecondView(){
        val tapMovie = PopularMovieVO(1.2,1,true,"https://www.posterPath",1,false,"https://www.backdropPath","en","Harry", ArrayList(1),"Paradise"
            ,1.2,"Good Movie","12/02/2020")
        mPresenter.onTapMovie(tapMovie.id)
        verify { mView.navigateToSecondView(tapMovie.id) }
    }

    @Test
    fun onUiReady_callGetAllPopularMovie_callDisplayPopularMovieList(){
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when` (lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)
        mPresenter.onUiReady(lifecycleOwner)
        verify {
            mView.displayPopularMovieList(getDummyPopularMovies())
        }

        verify {
            mView.displayGenereList(getDummyAllGenere())
        }

        verify {
            mView.displayBestActorList(getDummyActorList())
        }
    }
}