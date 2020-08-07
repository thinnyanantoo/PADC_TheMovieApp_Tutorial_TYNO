package com.example.padc_themovieapp_tutorial_tyno.mvp_presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.MockPopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.PopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.PopularMovieModel
import com.example.padc_themovieapp_tutorial_tyno.data.vos.CreditsVO
import com.example.padc_themovieapp_tutorial_tyno.data.vos.MovieDetailVO
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls.SecondPresenterImpl
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.SecondView
import com.example.padc_themovieapp_tutorial_tyno.utiils.getDummyMovieDetail
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
class SecondPresenterImplTest {
    private lateinit var mPresenter : SecondPresenterImpl

    @RelaxedMockK
    private lateinit var mView : SecondView

    private lateinit var mModel : PopularMovieModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        PopularMovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mModel = MockPopularMovieModelImpl

        mPresenter = SecondPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mPopularModel = this.mModel
    }

    @Test
    fun onUiReady_callgetMovieDetail_callshowMovieDetail(){
       var movieId = 5
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)
        mPresenter.onUiReady(movieId)
        verify {
            mView.showDetail(getDummyMovieDetail(MovieDetailVO().id))
        }
    }
}