package com.example.padc_themovieapp_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_themovieapp_tutorial_tyno.adapters.CrewAdapter
import kotlinx.android.synthetic.main.layout_creators.view.*

class CreatorViewPod  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
    }
    fun onBindCrewAdapter(crewAdapter: CrewAdapter){
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        rvCreators.layoutManager = linearLayoutManager
        rvCreators.adapter = crewAdapter
    }
}
