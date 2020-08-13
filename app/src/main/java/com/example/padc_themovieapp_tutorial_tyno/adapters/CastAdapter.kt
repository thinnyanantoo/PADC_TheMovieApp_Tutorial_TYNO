package com.example.padc_themovieapp_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.data.vos.castVO
import com.example.padc_themovieapp_tutorial_tyno.views.viewholders.CastViewHolder
import com.example.shared.adapter.BaseRecyclerAdapter

class CastAdapter : BaseRecyclerAdapter<CastViewHolder, castVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.rv_actor_layout,parent,false)
        return CastViewHolder(view)
    }
}