package com.example.padc_themovieapp_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_themovieapp_tutorial_tyno.data.vos.UpComingVO

@Dao
interface
UpComingMovieDao {

    @Query("SELECT * FROM upcoming")
    fun getAllUpComings(): LiveData<List<UpComingVO>>

    @Query("SELECT * FROM upcoming WHERE id = :upcomingId")
    fun getUpComingById (upcomingId: Int): LiveData<UpComingVO>

    @Query("DELETE FROM upcoming")
    fun deleteAll()

    @Delete
    fun deleteActor(upcomingmovie : UpComingVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpComings(upcomingVO :UpComingVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUpComings(upcoming: List<UpComingVO>)
}