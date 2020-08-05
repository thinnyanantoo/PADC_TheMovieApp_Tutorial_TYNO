package com.example.padc_themovieapp_tutorial_tyno.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetPopularMovieWorker (context : Context, workerParams: WorkerParameters) :
        BaseWorkers(context, workerParams){
    override fun doWork(): Result {

        var result = Result.failure()

        mPopularModel.getAllPopularMovieFromApiAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

        mPopularModel.getAllActorsFromApiAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

        mPopularModel.getAllUpComingFromApiAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },onError = {
                result = Result.failure()
            }
                )

        mPopularModel.getAllGenereFromApiAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                Result.failure()
            }
        )
        return result
    }
}