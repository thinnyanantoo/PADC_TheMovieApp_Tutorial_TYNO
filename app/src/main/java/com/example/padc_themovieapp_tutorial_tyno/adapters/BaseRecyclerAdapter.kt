package com.example.padc_themovieapp_tutorial_tyno.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.padc_themovieapp_tutorial_tyno.views.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<T : BaseViewHolder<W>,W> : RecyclerView.Adapter<T>(){

    var mData : MutableList<W> = arrayListOf()


    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.count()
    }

    fun setPopularUpdateData(data : MutableList<W>){
        mData =  data
        notifyDataSetChanged()
    }
}