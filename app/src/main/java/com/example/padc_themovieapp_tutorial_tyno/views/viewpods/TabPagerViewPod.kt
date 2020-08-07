package com.example.padc_themovieapp_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.padc_themovieapp_tutorial_tyno.adapters.rvfragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.layout_tab_list_view_pod.*
import kotlinx.android.synthetic.main.layout_tab_list_view_pod.view.*

class TabPagerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun onAttachTabAndPager(mrvfragmentAdapter: rvfragmentAdapter){
        tabLayout.removeAllTabs()
        viewPagerTab.adapter = mrvfragmentAdapter
        viewPagerTab.currentItem = 0


        TabLayoutMediator(tabLayout,viewPagerTab){ tab, position ->
            tab.text = mrvfragmentAdapter.genres[position].name
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }


            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPagerTab.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
        })

    }

}