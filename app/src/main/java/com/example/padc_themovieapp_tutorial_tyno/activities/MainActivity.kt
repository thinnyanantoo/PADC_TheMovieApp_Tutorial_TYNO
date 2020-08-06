package com.example.padc_themovieapp_tutorial_tyno.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls.MainPresenterImpl
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.MainPresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.MainView
import com.example.padc_themovieapp_tutorial_tyno.utiils.EMPTY_IMAGE_URL
import com.example.padc_themovieapp_tutorial_tyno.utiils.EM_NO_MOVIES_AVAILABLE
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.swipeRefreshLayout
import kotlinx.android.synthetic.main.layout_showcases.*
import kotlinx.android.synthetic.main.layout_tab_list_view_pod.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_themovieapp_tutorial_tyno.adapters.*
import com.example.padc_themovieapp_tutorial_tyno.data.vos.*
import com.example.padc_themovieapp_tutorial_tyno.views.viewpods.*
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.layout_best_actors.*
import kotlinx.android.synthetic.main.rv_movie_play_list.*

class MainActivity : AppCompatActivity() , MainView  {

    override fun displayGenereList(generes: List<GenereVO>) {
        setPagerAndTab(generes)
    }

    val movieId = 0

    private lateinit var mPresenter: MainPresenter

    private lateinit var viewPodEmpty: EmptyViewPod
    private lateinit var mRecyclerAdapter: FilmRecyclerAdapter
    private lateinit var mActorRecyclerAdapter: ActorRecyclerAdapter

    private lateinit var mrvfragmentAdapter: rvfragmentAdapter

    private lateinit var sliderViewPod: SliderViewPod
    private lateinit var popularMovieViewPod : PopularMovieViewPod
    private lateinit var showCaseViewPod : ShowcaseViewPod
    private lateinit var actorviewPod : BestActorViewPod
    private lateinit var tabandPagerViewPod : TabPagerViewPod

    private lateinit var msliderAdapter : ImageSliderAdapter
    private lateinit var mShowCaseAdapter: ShowCaseAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPodEmpty = vpEmpty as EmptyViewPod
        sliderViewPod = vpSliderVideo as SliderViewPod
        popularMovieViewPod = vpPopularMovie as PopularMovieViewPod
        showCaseViewPod = vpShowCase as ShowcaseViewPod
        actorviewPod = vpBestActor as BestActorViewPod
        tabandPagerViewPod = vpTabAndPager as TabPagerViewPod

        setUpPresenter()
        hideEmptyView()
        setUpSwipeRefresh()
        setUpRecycler()

        mPresenter.onUiReady(this)
    }


    override fun displayUpComingMovie(movieList: List<UpComingVO>) {
      // mViewPagerAdapter.setData(movieList.toMutableList())
    }


    override fun navigateToSecondView(movieId: Int) {
        startActivity(SecondActivity.newIntent(this, movieId))
    }

    override fun navigateToPlayerView(movieId: Int) {
        startActivity(VideoPlayerActivity.newIntent(this,movieId))
    }

    override fun displayPopularMovieList(movieList: List<PopularMovieVO>) {
        setUpSlider(movieList)
       popularMovieViewPod.onbindAdapter(mRecyclerAdapter,movieList.toMutableList())
       showCaseViewPod.bindShowCaseAdapter(mShowCaseAdapter,movieList.toMutableList())
    }

    override fun displayBestActorList(actorList: List<BestActorVO>) {
        actorviewPod.onBindActorAdapter(mActorRecyclerAdapter,actorList.toMutableList())
    }

    private fun setUpSlider(movies : List<PopularMovieVO>){
        msliderAdapter = ImageSliderAdapter(this)
        msliderAdapter.setData(movies.take(5))
        sliderViewPod.onAttachPagerAndTab(msliderAdapter)
    }

    private fun setPagerAndTab(generes: List<GenereVO>){
        mrvfragmentAdapter = rvfragmentAdapter(this,generes)
        tabandPagerViewPod.onAttachTabAndPager(mrvfragmentAdapter)
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun displayEmptyView() {
        //showEmptyView()
    }

    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            mPresenter.onSwipeRefrresh(this)
        }
    }

    private fun showEmptyView() {
        vpEmpty.visibility = View.VISIBLE
    }

    private fun hideEmptyView() {
        vpEmpty.visibility = View.GONE
    }

    private fun setUpViewPod() {
        viewPodEmpty.setEmptyData(EM_NO_MOVIES_AVAILABLE, EMPTY_IMAGE_URL)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    
    private fun setUpRecycler() {
        mRecyclerAdapter = FilmRecyclerAdapter(mPresenter)
        mShowCaseAdapter = ShowCaseAdapter(mPresenter)
        mActorRecyclerAdapter = ActorRecyclerAdapter(mPresenter)
    }
}











