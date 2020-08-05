package com.example.padc_themovieapp_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_themovieapp_tutorial_tyno.data.vos.BestActorVO

@Dao
interface ActorDao {

    @Query("SELECT * FROM bestactor")
    fun getAllBestActors():LiveData<List<BestActorVO>>

    @Query("SELECT * FROM bestactor WHERE id = :actorId")
    fun getActorById (actorId: Int): LiveData<BestActorVO>

    @Query("DELETE FROM bestactor")
    fun deleteAll()

    @Delete
    fun deleteActor(bestactor : BestActorVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActors(actorVO : BestActorVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllActors(bestactor : List<BestActorVO>)
}