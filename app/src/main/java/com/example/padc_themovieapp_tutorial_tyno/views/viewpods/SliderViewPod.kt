package com.example.padc_themovieapp_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.padc_themovieapp_tutorial_tyno.adapters.ImageSliderAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.layout_video.view.*

class SliderViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

//    override fun onFinishInflate() {
//        super.onFinishInflate()
//    }
    fun onAttachPagerAndTab(sliderAdapter: ImageSliderAdapter)
    {
        viewPagerSlider.adapter= sliderAdapter
        TabLayoutMediator(tbIndicator, viewPagerSlider) { tab, position ->
        }.attach()
    }

}