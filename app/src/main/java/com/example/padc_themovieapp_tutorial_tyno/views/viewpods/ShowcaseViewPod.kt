package com.example.padc_themovieapp_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_themovieapp_tutorial_tyno.adapters.ShowCaseAdapter
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import kotlinx.android.synthetic.main.layout_showcases.view.*

    class ShowcaseViewPod @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
    ) : LinearLayout(context, attrs, defStyleAttr) {

        override fun onFinishInflate() {
            super.onFinishInflate()
        }

    fun bindShowCaseAdapter(showCaseAdapter: ShowCaseAdapter,showCaseMovie : MutableList<PopularMovieVO>){
        val linearLayoutManagerFilm = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        rvShowCaseVideo.layoutManager = linearLayoutManagerFilm
        rvShowCaseVideo.adapter = showCaseAdapter
        showCaseAdapter.setPopularUpdateData(showCaseMovie)
    }
}