package com.example.padc_themovieapp_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.data.vos.GenereVO
import com.example.padc_themovieapp_tutorial_tyno.fragments.MovieListFragment

class rvfragmentAdapter(fragmentActivity: FragmentActivity, val genres : List<GenereVO>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {

        return genres.size
    }

    override fun createFragment(position: Int): Fragment {

        return MovieListFragment.newInstance(genres[position].id)
    }

}