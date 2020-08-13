package com.example.padc_themovieapp_tutorial_tyno.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieViewHolderDelegate
import com.example.padc_themovieapp_tutorial_tyno.utiils.IMAGE_URL
import com.example.shared.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.rv_tab.view.*

class TabRecyclerViewHolder (itemView : View, private val mDelegate : MovieViewHolderDelegate) : BaseViewHolder<PopularMovieVO>(itemView) {

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
            .into(itemView.ivGenere )
        itemView.tvGenereMovieName.text = data.title
        itemView.tvRbGenereVote.text = data.voteAverage.toString()
    }


}