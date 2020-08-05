package com.example.padc_themovieapp_tutorial_tyno.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.padc_themovieapp_tutorial_tyno.data.vos.BestActorVO
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieViewHolderDelegate
import com.example.padc_themovieapp_tutorial_tyno.utiils.IMAGE_URL
import kotlinx.android.synthetic.main.rv_best_actor_layout.view.*


class ActorRecyclerViewHolder(itemView : View,private val mDelegate : MovieViewHolderDelegate) : BaseViewHolder<BestActorVO>(itemView){
     init {
         itemView.setOnClickListener {
             mDelegate.onTapMovie(it.id)
         }
     }
     override fun bindData(data: BestActorVO) {
         mData = data
         var IMAGEURL = IMAGE_URL + "original" + data.profilePath
         Glide.with(itemView.context)
             .load(IMAGEURL)
             .into(itemView.ivBestActor)
         itemView.tvBestActorName.text = data.name
     }

 }