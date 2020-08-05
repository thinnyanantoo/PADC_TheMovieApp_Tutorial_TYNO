package com.example.padc_themovieapp_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import com.bumptech.glide.Glide
import com.example.padc_themovieapp_tutorial_tyno.R

import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.slider_image.view.*

class SliderAdapter : SliderViewAdapter<SliderViewHolder>() {

    var imageList = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.slider_image,parent,false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
       viewHolder?.let {
           Glide.with(it.itemView)
               .load(imageList[position])
               .into(viewHolder.ivSlider)
       }
    }

    override fun getCount(): Int {
       return imageList.size
    }
}

class SliderViewHolder(itemView: View) : SliderViewAdapter.ViewHolder(itemView){
    val ivSlider = itemView.ivSlider
}