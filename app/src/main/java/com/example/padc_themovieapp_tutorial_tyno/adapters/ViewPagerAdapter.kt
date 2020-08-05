//package com.example.padc_themovieapp_tutorial_tyno.adapters
//
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.viewpager.widget.PagerAdapter
//import com.bumptech.glide.Glide
//import com.example.padc_themovieapp_tutorial_tyno.R
//import com.example.padc_themovieapp_tutorial_tyno.data.vos.UpComingVO
//import com.example.padc_themovieapp_tutorial_tyno.delegates.MovieViewHolderDelegate
//import com.example.padc_themovieapp_tutorial_tyno.utiils.IMAGE_URL
//import com.google.android.youtube.player.YouTubeInitializationResult
//import com.google.android.youtube.player.YouTubePlayer
//import kotlinx.android.synthetic.main.layout_video.view.*
//
//
//class ViewPagerAdapter(private val delegate : MovieViewHolderDelegate): PagerAdapter(),YouTubePlayer.OnInitializedListener {
//
//   var mData: MutableList<UpComingVO> = arrayListOf()
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return `object` == view
//    }
//
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        var view =
//            LayoutInflater.from(container.context).inflate(R.layout.layout_video, container, false)
//
//
//        val IMAGEURL = IMAGE_URL + "original" + mData[position].backdropPath.toString()
//                Glide.with(view.context)
//                    .load(IMAGEURL)
//                    .into(view.image)
//
//
//        container.addView(view)
//
//        return view
//      // view.youtubeVideo.initialize(DUMMY_ACCESS_TOKEN)
//    }
//
//    override fun getCount(): Int {
//        return mData.size
//    }
//
//    fun setData(data : MutableList<UpComingVO>) {
//        mData = data
//        notifyDataSetChanged()
//    }
//
//    override fun onInitializationFailure(
//        p0: YouTubePlayer.Provider?,
//        p1: YouTubeInitializationResult?
//    ) {
//
//    }
//
//    override fun onInitializationSuccess(
//        p0: YouTubePlayer.Provider?,
//        p1: YouTubePlayer?,
//        p2: Boolean
//    ) {
//
//
//    }
//}
//
//
//
//
//
//
