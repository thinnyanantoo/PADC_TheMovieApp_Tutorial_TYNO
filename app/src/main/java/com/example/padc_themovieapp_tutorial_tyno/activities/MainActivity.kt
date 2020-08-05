package com.example.padc_themovieapp_tutorial_tyno.activities

import android.media.Image
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
import com.example.padc_themovieapp_tutorial_tyno.views.viewpods.EmptyViewPod
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.swipeRefreshLayout
import kotlinx.android.synthetic.main.layout_showcases.*
import kotlinx.android.synthetic.main.layout_tab_list_view_pod.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_themovieapp_tutorial_tyno.adapters.*
import com.example.padc_themovieapp_tutorial_tyno.data.vos.*
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.GenereFragmentView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.layout_best_actors.*
import kotlinx.android.synthetic.main.layout_video.*
import kotlinx.android.synthetic.main.rv_best_actor_layout.*
import kotlinx.android.synthetic.main.rv_movie_play_list.*

class MainActivity : AppCompatActivity() , MainView  {

    override fun displayGenereList(generes: List<GenereVO>) {
        setPagerAndTab(generes)
    }

    val movieId = 0


    override fun showVideo() {

    }

    private lateinit var mPresenter: MainPresenter

    private lateinit var viewPodEmpty: EmptyViewPod
    private lateinit var mRecyclerAdapter: FilmRecyclerAdapter
    private lateinit var mActorRecyclerAdapter: ActorRecyclerAdapter

   private lateinit var mrvfragmentAdapter: rvfragmentAdapter

 //  private lateinit var mViewPagerAdapter: ViewPagerAdapter

    private lateinit var sliderAdapter : ImageSliderAdapter
    private lateinit var mShowCaseAdapter: ShowCaseAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        hideEmptyView()
        setUpSwipeRefresh()

        //setUpImageSlider()
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
        mRecyclerAdapter.setPopularUpdateData(movieList.toMutableList())
        mShowCaseAdapter.setPopularUpdateData(movieList.reversed().toMutableList())
    }

    override fun displayBestActorList(actorList: List<BestActorVO>) {
      mActorRecyclerAdapter.setPopularUpdateData(actorList.toMutableList())

    }

//    private fun setUpImageSlider(){
//        viewPagerSlider.adapter= sliderAdapter
//        TabLayoutMediator(tbIndicator, viewPagerSlider) { tab, position ->
//        }.attach()
//
//    }

    private fun setUpSlider(movies : List<PopularMovieVO>){
        sliderAdapter = ImageSliderAdapter(this)
        sliderAdapter.setData(movies.take(5))
        viewPagerSlider.adapter= sliderAdapter
        TabLayoutMediator(tbIndicator, viewPagerSlider) { tab, position ->
        }.attach()

    }

    private fun setPagerAndTab(generes: List<GenereVO>){
        mrvfragmentAdapter = rvfragmentAdapter(this,generes)
        tabLayout.removeAllTabs()
        viewPagerTab.adapter = mrvfragmentAdapter
        viewPagerTab.currentItem = 0


        TabLayoutMediator(tabLayout,viewPagerTab){ tab, position ->
            tab.text = mrvfragmentAdapter.genres[position].name
        }.attach()

     tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
         override fun onTabReselected(tab: TabLayout.Tab?) {
         }


         override fun onTabSelected(tab: TabLayout.Tab?) {
             viewPagerTab.currentItem = tab!!.position
         }

         override fun onTabUnselected(tab: TabLayout.Tab?) {
         }
     })
    }

//    override fun displayMovieListInTab(movieList: List<PopularMovieVO>) {
//        mTabAdapter.setPopularUpdateData(movieList.toMutableList())
//    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun displayEmptyView() {
        showEmptyView()
    }

    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            mPresenter.onSwipeRefrresh(this)
        }
    }

    private fun setUplistener(){
        btnPlay.setOnClickListener {
            mPresenter.onTapPlay(movieId )
        }
    }

    private fun showEmptyView() {
      //  vpEmpty.visibility = View.VISIBLE
    }

    private fun hideEmptyView() {
        vpEmpty.visibility = View.GONE
    }

    private fun setUpViewPod() {
        viewPodEmpty = vpEmpty as EmptyViewPod
        viewPodEmpty.setEmptyData(EM_NO_MOVIES_AVAILABLE, EMPTY_IMAGE_URL)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    private fun setUpRecycler() {
        mRecyclerAdapter = FilmRecyclerAdapter(mPresenter)
        val linearLayoutManagerFilm = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvPopularFilm.layoutManager = linearLayoutManagerFilm
        rvPopularFilm.adapter = mRecyclerAdapter



        mActorRecyclerAdapter = ActorRecyclerAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvBestActor.layoutManager = linearLayoutManager
        rvBestActor.adapter = mActorRecyclerAdapter


        mShowCaseAdapter = ShowCaseAdapter(mPresenter)
        val linearLayoutManagerShowCase = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvShowCaseVideo.layoutManager = linearLayoutManagerShowCase
        rvShowCaseVideo.adapter = mShowCaseAdapter

    }


//    private fun setUpTabAdapter() {
//        TabLayout.TabLayoutOnPageChangeListener(tabLayout)
//        tabLayout.addTab(tabLayout.newTab().setText(fragmentTitleList[0]))
//        tabLayout.addTab(tabLayout.newTab().setText(fragmentTitleList[1]))
//        tabLayout.addTab(tabLayout.newTab().setText(fragmentTitleList[2]))
//        tabLayout.addTab(tabLayout.newTab().setText(fragmentTitleList[3]))
//
//        tabLayout.addOnTabSelectedListener(object :
//            TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                mTabAdapter = TabRecyclerAdapter(mPresenter)
//                //mPresenter.onSelectTab(tab.position)
//               }
//            override fun onTabUnselected(tab: TabLayout.Tab) {
//            }
//            override fun onTabReselected(tab: TabLayout.Tab) {
//            }
//        })
//
//    }
//
//    private fun setUpViewPagerAdapter(){
//        mViewPagerAdapter = ViewPagerAdapter(mPresenter)
//        viewPager.adapter = mViewPagerAdapter
//    }

    }











