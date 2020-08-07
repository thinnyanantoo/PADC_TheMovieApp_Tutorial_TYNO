package com.example.padc_themovieapp_tutorial_tyno.uiTests

import android.content.Intent
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
import com.example.padc_themovieapp_tutorial_tyno.views.viewholders.ShowCaseViewHoler
import kotlinx.android.synthetic.main.layout_showcases.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToPlayerTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun onTapShowCase_GoToVideoPlayer(){
        Thread.sleep(3000)
        onView(withId(R.id.rvShowCaseVideo))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ShowCaseViewHoler>(0, click()))
        onView(withId(R.id.videoPlayer))
            .check(matches(isDisplayed()))
    }
}