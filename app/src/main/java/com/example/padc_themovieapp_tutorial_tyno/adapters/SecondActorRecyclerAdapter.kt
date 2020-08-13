package com.example.padc_themovieapp_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.data.vos.BestActorVO
import com.example.padc_themovieapp_tutorial_tyno.views.viewholders.SecondActorViewHolder
import com.example.shared.adapter.BaseRecyclerAdapter

class SecondActorRecyclerAdapter : BaseRecyclerAdapter<SecondActorViewHolder, BestActorVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondActorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_actor_layout, parent, false)
        return SecondActorViewHolder(view)
    }
}