package com.example.padc_themovieapp_tutorial_tyno.mvp_presenters.impls

import android.widget.VideoView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.MockPopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.PopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.PopularMovieModel
import com.example.padc_themovieapp_tutorial_tyno.data.vos.VideoVO
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls.VideoPlayerPresenterImpl
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.VideoPlayerView
import com.example.padc_themovieapp_tutorial_tyno.utiils.getDummyVideo
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
class VideoPlayerImplTest {
    private lateinit var mPresenter : VideoPlayerPresenterImpl

    @RelaxedMockK
    private lateinit var mView : VideoPlayerView

    private lateinit var mModel : PopularMovieModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        PopularMovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mModel= MockPopularMovieModelImpl

        mPresenter = VideoPlayerPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mPopularModel = this.mModel
    }

    @Test
    fun onUiReady_callGetMovie_andCallGetVideo(){
        val movieId = 12
        val lifeCycleOwner = mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)
        mPresenter.onUiReady(movieId)
        verify {
            mView.showVideo(getDummyVideo(movieId).key)
        }

    }

}