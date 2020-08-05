package com.example.padc_themovieapp_tutorial_tyno.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.padc_themovieapp_tutorial_tyno.data.vos.castVO
import com.example.padc_themovieapp_tutorial_tyno.utiils.IMAGE_URL
import kotlinx.android.synthetic.main.rv_actor_layout.view.*

class CastViewHolder(itemView : View) : BaseViewHolder<castVO>(itemView) {
    override fun bindData(data: castVO) {
        var IMAGE_URL = IMAGE_URL + "original" + data.profilePath
        Glide.with(itemView.context)
            .load(IMAGE_URL)
            .into(itemView.ivActor)

        itemView.tvActorName.text = data.name
    }
}