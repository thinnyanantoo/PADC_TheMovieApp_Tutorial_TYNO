package com.example.padc_themovieapp_tutorial_tyno.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.padc_themovieapp_tutorial_tyno.data.models.Impls.PopularMovieModelImpl
import com.example.padc_themovieapp_tutorial_tyno.data.models.PopularMovieModel

abstract class BaseWorkers (context : Context, workerParams: WorkerParameters): Worker(context,workerParams) {
    val mPopularModel : PopularMovieModel = PopularMovieModelImpl
}