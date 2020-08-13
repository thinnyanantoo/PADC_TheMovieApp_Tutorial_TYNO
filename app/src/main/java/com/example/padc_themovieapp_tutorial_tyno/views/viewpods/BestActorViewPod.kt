package com.example.padc_themovieapp_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_themovieapp_tutorial_tyno.adapters.ActorRecyclerAdapter
import com.example.padc_themovieapp_tutorial_tyno.data.vos.BestActorVO
import kotlinx.android.synthetic.main.layout_best_actors.view.*

class BestActorViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

//    override fun onFinishInflate() {
//        super.onFinishInflate()
//    }

    fun onBindActorAdapter(actorRecyclerAdapter : ActorRecyclerAdapter,actorList : MutableList<BestActorVO>){
        val linearLayoutManagerFilm = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        rvBestActor.layoutManager = linearLayoutManagerFilm
        rvBestActor.adapter = actorRecyclerAdapter
        actorRecyclerAdapter.setPopularUpdateData(actorList)
    }
}