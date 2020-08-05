package com.example.padc_themovieapp_tutorial_tyno.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T> (itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mData : T? = null

    abstract fun bindData(data: T)
}