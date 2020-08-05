package com.example.padc_themovieapp_tutorial_tyno.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.padc_themovieapp_tutorial_tyno.data.vos.*
import com.example.padc_themovieapp_tutorial_tyno.persistence.daos.ActorDao
import com.example.padc_themovieapp_tutorial_tyno.persistence.daos.GenereDao
import com.example.padc_themovieapp_tutorial_tyno.persistence.daos.PopularMovieDao
import com.example.padc_themovieapp_tutorial_tyno.persistence.daos.UpComingMovieDao
import com.example.padc_themovieapp_tutorial_tyno.persistence.typeconverters.GenereTypeConverters
import com.example.padc_themovieapp_tutorial_tyno.persistence.typeconverters.KnownForTypeConverters
import com.example.padc_themovieapp_tutorial_tyno.persistence.typeconverters.OriginalCountryTypeConverters

@Database(entities = [PopularMovieVO::class, BestActorVO::class,UpComingVO::class,GenereVO::class], version = 14, exportSchema = false)
@TypeConverters(GenereTypeConverters::class,KnownForTypeConverters::class,OriginalCountryTypeConverters::class)
abstract class PopularMovieDB : RoomDatabase(){
    companion object {
        val DB_NAME = "PopularMovieDB"
        var dbInstance: PopularMovieDB? = null


        fun getDBInstance(context: Context): PopularMovieDB {
            when(dbInstance){
                null -> {
                    dbInstance = Room.databaseBuilder(
                        context, PopularMovieDB::class.java , DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()

                }
            }
            val i = dbInstance
            return i!!
        }
    }
    abstract fun PopularDao(): PopularMovieDao

    abstract fun ActorDao(): ActorDao


    abstract fun GenereDao(): GenereDao

    abstract fun UpComingMovieDao() : UpComingMovieDao

}