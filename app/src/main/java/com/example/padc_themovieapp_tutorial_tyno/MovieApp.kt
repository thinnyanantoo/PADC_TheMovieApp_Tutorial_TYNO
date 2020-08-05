package com.example.padc_themovieapp_tutorial_tyno

import android.app.Application
import androidx.work.*
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.PopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.workers.GetPopularMovieWorker
import java.util.concurrent.TimeUnit


class MovieApp : Application() {


    override fun onCreate() {
        super.onCreate()
        PopularMovieModelImpl.initDatabase(applicationContext)


        getMovieOneTime()
        getMoviePeriodically()
        getMovieWhileInDozeMode()
    }

    private fun getMovieOneTime(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetPopularMovieWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

    private fun getMoviePeriodically(){
        val constraints = Constraints
            .Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val getEventsPeriodicallyWorkRequest = PeriodicWorkRequest
            .Builder(GetPopularMovieWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsPeriodicallyWorkRequest)
    }

    private fun getMovieWhileInDozeMode(){
        val constraints = Constraints
            .Builder()
            .setRequiresDeviceIdle(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val getEventsWhileInDozeModeWorkRequest = PeriodicWorkRequest
            .Builder(GetPopularMovieWorker::class.java, 1, TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWhileInDozeModeWorkRequest)
    }
   }