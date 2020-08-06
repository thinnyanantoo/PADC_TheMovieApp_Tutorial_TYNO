package com.example.padc_themovieapp_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.padc_themovieapp_tutorial_tyno.R

import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.fragment_image_slider.view.*
import kotlinx.android.synthetic.main.slider_image.view.*

class SliderAdapter : SliderViewAdapter<SliderViewHolder>() {

    var imageList = mutableListOf<String>()
   // var nameList = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.slider_image,parent,false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
       viewHolder?.let {
           Glide.with(it.itemView)
               .load(imageList[position])
               .into(viewHolder.ivSlider)

           viewHolder.tvSliderName.text = imageList[position]

       }
    }

    override fun getCount(): Int {
       return imageList.size
     //   return nameList.size
    }
}

class SliderViewHolder(itemView: View) : SliderViewAdapter.ViewHolder(itemView){
    val ivSlider = itemView.ivSlider
    val tvSliderName = itemView.tvSliderMovieName
}