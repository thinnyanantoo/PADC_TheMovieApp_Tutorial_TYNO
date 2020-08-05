package com.example.padc_themovieapp_tutorial_tyno.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.padc_themovieapp_tutorial_tyno.data.vos.crewVO
import com.example.padc_themovieapp_tutorial_tyno.utiils.IMAGE_URL
import kotlinx.android.synthetic.main.rv_creaters.view.*

class CrewViewHolder(itemView : View) : BaseViewHolder<crewVO>(itemView) {
    override fun bindData(data: crewVO) {
        var IMAGE_URL = IMAGE_URL + "original" + data.profilePath

        Glide.with(itemView.context)
            .load(IMAGE_URL)
            .into(itemView.ivCreator)

        itemView.tvCreatorName.text = data.name
    }

}