package com.example.padc_themovieapp_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO

@Dao
interface PopularMovieDao {

    @Query("SELECT * FROM popularmovies")
    fun getAllPopularMovies():LiveData<List<PopularMovieVO>>

    @Query("SELECT * FROM popularmovies WHERE id = :popularId")
    fun getPopularMovieById (popularId: Int): LiveData<PopularMovieVO>

    @Query("DELETE FROM popularmovies")
    fun deleteAll()

    @Delete
    fun deletePopularMovies(popularMovie : PopularMovieVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovies(popularVO : PopularMovieVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPopularMovies(popularmovies : List<PopularMovieVO>)

}