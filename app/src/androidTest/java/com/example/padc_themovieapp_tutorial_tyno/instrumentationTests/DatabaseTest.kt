package com.example.padc_themovieapp_tutorial_tyno.instrumentationTests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.padc_themovieapp_tutorial_tyno.data.vos.BestActorVO
import com.example.padc_themovieapp_tutorial_tyno.data.vos.GenereVO
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO
import com.example.padc_themovieapp_tutorial_tyno.persistence.daos.ActorDao
import com.example.padc_themovieapp_tutorial_tyno.persistence.daos.GenereDao
import com.example.padc_themovieapp_tutorial_tyno.persistence.daos.PopularMovieDao
import com.example.padc_themovieapp_tutorial_tyno.persistence.db.PopularMovieDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {
    private lateinit var popularMovieDao: PopularMovieDao
    private lateinit var actorDao: ActorDao
    private lateinit var genereDao: GenereDao

    private lateinit var db: PopularMovieDB

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,PopularMovieDB::class.java).build()
        popularMovieDao = db.PopularDao()
        actorDao = db.ActorDao()
        genereDao = db.GenereDao()
    }

    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun insertPopularMovieIntoDataBaseTest(){
        val popularOne = PopularMovieVO()
        popularOne.title = "Run"
        popularOne.popularity=1.2
        popularOne.originalLanguage="korea"
        popularOne.overview="Good Variety Show"
        popularOne.adult= false
        popularOne.backdropPath="https://vignette.wikia.nocookie.net"
        popularOne.posterPath="https://www.posterPath"
        popularOne.releaseDate="20/05/2013"
        popularOne.voteAverage=1.2
        popularMovieDao.insertPopularMovies(popularOne)
        assert(popularMovieDao.getPopularMovieById(popularOne.id).value?.title == popularOne.title)
    }

    @Test
    fun insertActorIntoDataBaseTest(){
        val actorOne = BestActorVO(1.2, "K",2,1,"www.posterpath",false, ArrayList(1),"V")
        actorDao.insertActors(actorOne)
        assert(actorDao.getActorById(actorOne.id).value?.name == actorOne.name)
    }

    @Test
    fun insertGenereIntoDataBaseTest(){
        val genereOne = GenereVO(1,"HORROR")
        genereDao.insertGenere(genereOne)
        assert(genereDao.getGenereById(genereOne.id).value?.id == genereOne.id)
    }
}