package com.example.padc_themovieapp_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_themovieapp_tutorial_tyno.adapters.FilmRecyclerAdapter
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import kotlinx.android.synthetic.main.popular_movie_view_pod.view.*

class PopularMovieViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    override fun onFinishInflate() {
        super.onFinishInflate()

    }

    fun onbindAdapter(popularMovieAdapter : FilmRecyclerAdapter, popularMovies : MutableList<PopularMovieVO>){
        val linearLayoutManagerFilm = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
       rvPopularFilm.layoutManager = linearLayoutManagerFilm
        rvPopularFilm.adapter = popularMovieAdapter
        popularMovieAdapter.setPopularUpdateData(popularMovies)
    }
}