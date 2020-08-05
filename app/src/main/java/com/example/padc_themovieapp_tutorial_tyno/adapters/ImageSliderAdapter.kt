package com.example.padc_themovieapp_tutorial_tyno.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.padc_themovieapp_tutorial_tyno.fragments.ImageSliderFragment

class ImageSliderAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){

    var movies: List<PopularMovieVO> = listOf()

    override fun createFragment(position: Int): Fragment {
        return ImageSliderFragment.newInstance(movies[position].posterPath,movies[position].id.toInt())
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setData(popularMovies : List<PopularMovieVO>){
        movies = popularMovies
//        notifyDataSetChanged()
    }
}