package com.example.padc_themovieapp_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.data.vos.BestActorVO
import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieViewHolderDelegate
import com.example.padc_themovieapp_tutorial_tyno.views.viewholders.ActorRecyclerViewHolder
import com.example.shared.adapter.BaseRecyclerAdapter

class ActorRecyclerAdapter(private val mDelegate : MovieViewHolderDelegate) : BaseRecyclerAdapter<ActorRecyclerViewHolder, BestActorVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_best_actor_layout,parent,false)
        return ActorRecyclerViewHolder(view,mDelegate)
    }

}