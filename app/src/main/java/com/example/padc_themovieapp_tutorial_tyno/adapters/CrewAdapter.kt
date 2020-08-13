package com.example.padc_themovieapp_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.data.vos.crewVO
import com.example.padc_themovieapp_tutorial_tyno.views.viewholders.CrewViewHolder
import com.example.shared.adapter.BaseRecyclerAdapter

class CrewAdapter : BaseRecyclerAdapter<CrewViewHolder, crewVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.rv_creaters,parent,false)
        return CrewViewHolder(view)
    }
}