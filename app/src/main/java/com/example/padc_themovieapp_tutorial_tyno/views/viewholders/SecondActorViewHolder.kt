package com.example.padc_themovieapp_tutorial_tyno.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.padc_themovieapp_tutorial_tyno.data.vos.BestActorVO
import com.example.padc_themovieapp_tutorial_tyno.utiils.IMAGE_URL
import com.example.shared.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.rv_actor_layout.view.*


class SecondActorViewHolder (itemView : View) : BaseViewHolder<BestActorVO>(itemView){


    override fun bindData(data: BestActorVO) {
        mData = data
        var IMAGEURL = IMAGE_URL + "original" + data.profilePath
        Glide.with(itemView.context)
            .load(IMAGEURL)
            .into(itemView.ivActor)
        itemView.tvActorName.text = data.name
    }

}