package com.example.padc_themovieapp_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieTabDelegate
import com.example.padc_themovieapp_tutorial_tyno.views.viewholders.ShowCaseViewHoler
import com.example.shared.adapter.BaseRecyclerAdapter

class ShowCaseAdapter(private val delegate : MovieTabDelegate) : BaseRecyclerAdapter<ShowCaseViewHoler, PopularMovieVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCaseViewHoler {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.rv_movie_play_list,parent,false)
        return ShowCaseViewHoler(view,delegate)
    }
}