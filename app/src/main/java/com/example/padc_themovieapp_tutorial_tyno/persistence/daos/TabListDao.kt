//package com.example.padc_themovieapp_tutorial_tyno.persistence.daos
//
//import androidx.lifecycle.LiveData
//import androidx.room.*
//import com.example.padc_themovieapp_tutorial_tyno.data.vos.TabListVO
//
//@Dao
//interface TabListDao {
//    @Query("SELECT * FROM tablist")
//    fun getAllTabList(): LiveData<List<TabListVO>>
//
//    @Query("SELECT * FROM tablist WHERE id = :popularId")
//    fun getTabListById (popularId: Int): LiveData<TabListVO>
//
//    @Query("DELETE FROM tablist")
//    fun deleteAll()
//
//    @Delete
//    fun deletePopularMovies(popularMovie : TabListVO)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertTabList(tabListVO : TabListVO)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertAllTabListMovies(popularmovies : List<TabListVO>)
//
//}
