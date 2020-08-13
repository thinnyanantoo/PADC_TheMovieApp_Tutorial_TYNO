package com.example.padc_themovieapp_tutorial_tyno.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieViewHolderDelegate
import com.example.padc_themovieapp_tutorial_tyno.utiils.IMAGE_URL
import com.example.shared.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.rv_best_popular_film.view.*

class FilmRecyclerViewHolder(itemView : View,private val mDelegate : MovieViewHolderDelegate) : BaseViewHolder<PopularMovieVO>(itemView) {
    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapMovie(it.id)
            }
        }
    }

    override fun bindData(data: PopularMovieVO) {
        mData = data

        var ImgaeUrl = IMAGE_URL +  "original" + data.backdropPath
        Glide.with(itemView.context)
            .load(ImgaeUrl)
            .into(itemView.ivPopular )
        itemView.tvPopularMovieName.text = data.title
        itemView.tvRbPopularVote.text = data.voteAverage.toString()
    }


}