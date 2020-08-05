package com.example.padc_themovieapp_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.padc_themovieapp_tutorial_tyno.data.vos.TabListVO
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieViewHolderDelegate
import com.example.padc_themovieapp_tutorial_tyno.views.viewholders.TabRecyclerViewHolder

class TabRecyclerAdapter (private val delegate : MovieViewHolderDelegate) : BaseRecyclerAdapter<TabRecyclerViewHolder, PopularMovieVO>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_tab,parent,false)
        return TabRecyclerViewHolder(view,delegate)
    }

}