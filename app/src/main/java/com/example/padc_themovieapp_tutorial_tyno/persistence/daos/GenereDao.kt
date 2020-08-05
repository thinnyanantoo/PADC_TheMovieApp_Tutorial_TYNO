package com.example.padc_themovieapp_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_themovieapp_tutorial_tyno.data.vos.GenereVO

@Dao
interface GenereDao {
    @Query("SELECT * FROM generestable")
    fun getAllGeneres(): LiveData<List<GenereVO>>

    @Query("SELECT * FROM generestable WHERE id = :popularId")
    fun getGenereById (popularId: Int): LiveData<GenereVO>

    @Query("DELETE FROM generestable")
    fun deleteAll()

    @Delete
    fun deleteGenere(popularMovie : GenereVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenere(genereVO : GenereVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGenere(generestable : List<GenereVO>)
}