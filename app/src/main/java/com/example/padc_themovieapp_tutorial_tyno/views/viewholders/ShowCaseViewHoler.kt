package com.example.padc_themovieapp_tutorial_tyno.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieTabDelegate
import com.example.padc_themovieapp_tutorial_tyno.utiils.IMAGE_URL
import kotlinx.android.synthetic.main.rv_movie_play_list.view.*

class ShowCaseViewHoler(itemView: View,private val mDelegate : MovieTabDelegate) : BaseViewHolder<PopularMovieVO>(itemView){
    init {
        itemView.setOnClickListener {
            mDelegate.onTapPlay(mData?.id?.toInt() ?:0)
        }
    }
    override fun bindData(data: PopularMovieVO) {
        mData = data
        var IMAGE_URL = IMAGE_URL + "original" + data.posterPath
        Glide.with(itemView.context)
            .load(IMAGE_URL)
            .into(itemView.ivShowCases)

        itemView.tvShowCaseName.text = data.originalTitle
    }

}