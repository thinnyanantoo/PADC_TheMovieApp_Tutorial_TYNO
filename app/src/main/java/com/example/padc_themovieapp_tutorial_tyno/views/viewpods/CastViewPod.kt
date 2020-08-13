package com.example.padc_themovieapp_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_themovieapp_tutorial_tyno.adapters.CastAdapter
import kotlinx.android.synthetic.main.layout_best_actors.view.*
import kotlinx.android.synthetic.main.layout_cast_view_pod.view.*

class CastViewPod  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

//    override fun onFinishInflate() {
//        super.onFinishInflate()
//    }

    fun onbindActorAdapter (castAdapter: CastAdapter){
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rvCast.layoutManager = linearLayoutManager
        rvCast.adapter = castAdapter
    }
}