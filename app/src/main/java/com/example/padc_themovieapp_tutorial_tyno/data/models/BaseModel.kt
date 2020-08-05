package com.example.padc_themovieapp_tutorial_tyno.data.models

import android.content.Context
import com.example.padc_themovieapp_tutorial_tyno.network.PopularMovieApi
import com.example.padc_themovieapp_tutorial_tyno.persistence.db.PopularMovieDB
import com.example.padc_themovieapp_tutorial_tyno.utiils.BASE_POPULAR_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected  var mApi : PopularMovieApi
    protected lateinit var mTheDB : PopularMovieDB

    init {
        val mOkHttpBuilder = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_POPULAR_URL)
            .client(mOkHttpBuilder)
            .addConverterFactory( GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mApi = retrofit.create(PopularMovieApi::class.java)

    }

   fun initDatabase(context : Context) {
      mTheDB = PopularMovieDB.getDBInstance(context)
   }


}