package com.example.padc_themovieapp_tutorial_tyno.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieViewHolderDelegate
import com.example.padc_themovieapp_tutorial_tyno.views.viewholders.FilmRecyclerViewHolder
import com.example.shared.adapter.BaseRecyclerAdapter

class FilmRecyclerAdapter(private val delegate : MovieViewHolderDelegate) : BaseRecyclerAdapter<FilmRecyclerViewHolder, PopularMovieVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_best_popular_film,parent,false)
        return FilmRecyclerViewHolder(view,delegate)
    }

}