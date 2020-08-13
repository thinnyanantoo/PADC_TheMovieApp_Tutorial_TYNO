package com.example.padc_themovieapp_tutorial_tyno.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.adapters.CastAdapter
import com.example.padc_themovieapp_tutorial_tyno.adapters.CrewAdapter
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.PopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.PopularMovieModel
import com.example.padc_themovieapp_tutorial_tyno.data.vos.*
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieTabDelegate
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls.SecondPresenterImpl
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.SecondPresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.SecondView
import com.example.padc_themovieapp_tutorial_tyno.utiils.EMPTY_IMAGE_URL
import com.example.padc_themovieapp_tutorial_tyno.utiils.EM_NO_MOVIES_AVAILABLE
import com.example.padc_themovieapp_tutorial_tyno.utiils.IMAGE_URL
import com.example.padc_themovieapp_tutorial_tyno.views.viewpods.CastViewPod
import com.example.padc_themovieapp_tutorial_tyno.views.viewpods.CreatorViewPod
import com.example.padc_themovieapp_tutorial_tyno.views.viewpods.EmptyViewPod
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.swipeRefreshLayout
import kotlinx.android.synthetic.main.layout_best_actors.*
import kotlinx.android.synthetic.main.layout_creators.*

class SecondActivity : AppCompatActivity() , SecondView {

    private lateinit var mCrewAdapter: CrewAdapter
    private lateinit var mCastAdapter : CastAdapter

    private lateinit var mPresenter : SecondPresenter

    private var mPopularModel : PopularMovieModel = PopularMovieModelImpl

    private lateinit var viewPodEmpty: EmptyViewPod
    private lateinit var castViewPod : CastViewPod
    private lateinit var creatorViewPod: CreatorViewPod

    var movieId = 0


    companion object {

        const val MOVIES_ID_EXTRA = "MOVIES ID EXTRA"

        fun newIntent(context: Context, moviesId : Int): Intent {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(MOVIES_ID_EXTRA, moviesId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        castViewPod = vpCast as CastViewPod
        viewPodEmpty= vpEmptySecond as EmptyViewPod
        creatorViewPod = vpCreator as CreatorViewPod


        setUpPresenter()
        movieId = intent.getIntExtra(MOVIES_ID_EXTRA, 0)
        setUpRecycler()
        setUpListener()
        setGetData()
        mPresenter.onUiReady(movieId)

    }

    override fun showDetail(movieDetailVO: MovieDetailVO) {
       mCastAdapter.setPopularUpdateData(movieDetailVO.credits.cast.toMutableList())
        mCrewAdapter.setPopularUpdateData(movieDetailVO.credits.crew.toMutableList())
        tvOriginalImpl.text = movieDetailVO.originalTitle
        tvDescriptionImpl.text = movieDetailVO.overview
        tvPremiereImpl.text = movieDetailVO.releaseDate
        tvTypeImpl.text = movieDetailVO.genres[0].name
        tvProductionImpl.text = movieDetailVO.productionCountries[0].name
        averageVote.text = movieDetailVO.voteAverage.toString()
        voteCount.text = "${movieDetailVO.voteCount}\t votes"
        tvTime.text =  "${movieDetailVO.runTime/60}h ${movieDetailVO.runTime%60}min"


    }
    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun displayEmptyView() {
      //  showEmptyView()
    }

    private fun setGetData(){
        val moviesId = intent.getIntExtra(MOVIES_ID_EXTRA, 0)
        mPopularModel.getPopularMoviesById(moviesId)
            .observe(this, Observer {
                bindData(it!!)
            })
    }

    private fun bindData(movies : PopularMovieVO){

        val IMAGE_URL = IMAGE_URL+ "original" + movies?.backdropPath
        tvOverView.text = movies.overview

        tvMovieTitle.text = movies.title

        Glide.with(this)
            .load(IMAGE_URL)
            .into(ivOverViewMovie)
    }

    private fun setUpRecycler(){
        mCastAdapter = CastAdapter()
        castViewPod.onbindActorAdapter(mCastAdapter)
        mCrewAdapter = CrewAdapter()
        creatorViewPod.onBindCrewAdapter(mCrewAdapter)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(SecondPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpListener(){
        ivBack.setOnClickListener {
            finish()
        }
    }
    private fun showEmptyView(){
        vpEmptySecond.visibility = View.VISIBLE
    }

    private fun hideEmptyView(){
        vpEmptySecond.visibility = View.GONE
    }

    private fun setUpViewPod() {
        viewPodEmpty.setEmptyData(EM_NO_MOVIES_AVAILABLE, EMPTY_IMAGE_URL)
    }



}
