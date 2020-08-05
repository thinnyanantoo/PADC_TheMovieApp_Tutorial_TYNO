package com.example.padc_themovieapp_tutorial_tyno.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.example.padc_themovieapp_tutorial_tyno.R
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.Impls.VideoPlayerPresenterImpl
import com.example.padc_themovieapp_tutorial_tyno.mvp.presenters.VideoPlayerPresenter
import com.example.padc_themovieapp_tutorial_tyno.mvp.views.VideoPlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() , VideoPlayerView {
    override fun showVideo(key: String) {
        videoPlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(key,0f)
            }
        })
    }

    override fun enableSwipeRefresh() {

    }

    override fun disableSwipeRefresh() {

    }

    override fun displayEmptyView() {
    }

    private lateinit var mPresenter : VideoPlayerPresenter


    companion object {

        const val MOVIES_ID_EXTRA = "MOVIES ID EXTRA"

        fun newIntent(context: Context, moviesId : Int): Intent {
            val intent = Intent(context, VideoPlayerActivity::class.java)
            intent.putExtra(MOVIES_ID_EXTRA, moviesId)
            return intent
        }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(VideoPlayerPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        setUpPresenter()
        lifecycle.addObserver(videoPlayer)

        val movieId = intent.getIntExtra(MOVIES_ID_EXTRA,0)

        mPresenter.onUiReady(movieId)
    }
}
