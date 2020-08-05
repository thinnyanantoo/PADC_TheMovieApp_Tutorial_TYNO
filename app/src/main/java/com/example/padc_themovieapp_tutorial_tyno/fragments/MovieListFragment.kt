package com.example.padc_themovieapp_tutorial_tyno.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.activities.SecondActivity
import com.example.padc_themovieapp_tutorial_tyno.adapters.TabRecyclerAdapter
import com.example.padc_themovieapp_tutorial_tyno.adapters.rvfragmentAdapter
import com.example.padc_themovieapp_tutorial_tyno.data.vos.GenereVO
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.GenereFragmentPresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls.GenereFragmentPresenterImpl
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.GenereFragmentView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_rv_list.*
import kotlinx.android.synthetic.main.layout_tab_list_view_pod.*

class MovieListFragment : Fragment() , GenereFragmentView{

//    override fun displayGenereList(generes: List<GenereVO>) {
//        setPagerAndTab(generes)
//    }
     private lateinit var mTabAdapter: TabRecyclerAdapter
    private lateinit var mPresenter : GenereFragmentPresenter

    private lateinit var mrvfragmentAdapter: rvfragmentAdapter

    companion object{
        const val GENRE_ID_KEY = "genreId"
        fun newInstance(genreId : Int) : MovieListFragment{
            val bundle = Bundle()
            bundle.putInt(GENRE_ID_KEY,genreId)
            val fragment = MovieListFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rv_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        val genereId = arguments?.getInt(GENRE_ID_KEY) ?: 0
        setUpRecycler()
        mPresenter.onUiReady(this,genereId)

    }

    override fun displayGenereMovieList(movies: List<PopularMovieVO>) {
        mTabAdapter.setPopularUpdateData(movies.toMutableList())
    }


    override fun navigateDetail(movieId: Int) {
        context?.let{
                    startActivity(SecondActivity.newIntent(it, movieId))
      }

    }



    override fun disableSwipeRefresh() {

    }

    override fun displayEmptyView() {


    }

    override fun enableSwipeRefresh() {


    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(activity!!).get(GenereFragmentPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecycler(){
        mTabAdapter = TabRecyclerAdapter(mPresenter)
        val mtabLinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvfragmentMovieList.layoutManager = mtabLinearLayoutManager
        rvfragmentMovieList.adapter = mTabAdapter
    }

    private fun setPagerAndTab(generes : List<GenereVO>){
        mrvfragmentAdapter = rvfragmentAdapter(requireActivity(),generes)
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

    private fun showEmptyView(){
     //   vpEmpty.visibility = View.VISIBLE
    }

    private fun hideEmptyView(){
     //   vpEmpty.visibility = View.GONE
    }



