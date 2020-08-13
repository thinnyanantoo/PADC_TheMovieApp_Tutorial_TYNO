package com.example.padc_themovieapp_tutorial_tyno.uiTests

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.activities.MainActivity
import com.example.padc_themovieapp_tutorial_tyno.views.viewholders.FilmRecyclerViewHolder
import com.example.padc_themovieapp_tutorial_tyno.views.viewholders.TabRecyclerViewHolder
import kotlinx.android.synthetic.main.popular_movie_view_pod.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToDetailTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnMovies_navigateToMovieDetails(){
        onView(withId(R.id.rvPopularFilm))
            .perform(RecyclerViewActions.actionOnItemAtPosition<FilmRecyclerViewHolder>(0,click()))
        onView(withId(R.id.tvOverView))
            .check(matches(isDisplayed()))
    }


    @Test
    fun tapOnGenereMovie_navigateToMovieDetails(){
        Thread.sleep(3000)
        onView(withId(R.id.rvfragmentMovieList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TabRecyclerViewHolder>(0, click()))
        onView(withId(R.id.tvOverView))
            .check(matches(isDisplayed()))
    }


}
