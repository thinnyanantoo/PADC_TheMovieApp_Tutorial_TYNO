package com.example.padc_themovieapp_tutorial_tyno.network

import com.example.padc_themovieapp_tutorial_tyno.data.vos.MovieDetailVO
import com.example.padc_themovieapp_tutorial_tyno.data.vos.VideoVO
import com.example.padc_themovieapp_tutorial_tyno.network.responses.*
import com.example.padc_themovieapp_tutorial_tyno.utiils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PopularMovieApi {
    @GET(GET_POPULAR_MOVIE)
    fun getAllPopularMovies(@Query(PARAM_API_KEY)paramApiKey : String) : Observable<GetAllPopularMovieResponse>

    @GET(GET_ACTOR)
    fun getAllActors(@Query(PARAM_API_KEY)paramApiKey: String) : Observable<GetAllActorResponse>

//    @GET(GET_LIST)
//    fun getAllTabList(@Query(PARAM_API_KEY)paramApiKey: String) : Observable<GetAllListResponse>

    @GET(GET_UPCOMMING_MOVIE_ID)
    fun getAllUpComing(@Query(PARAM_API_KEY)paramApiKey: String) : Observable<GetAllUpComingResponse>

    @GET("movie/{MOVIE_ID}")
    fun getMovieDetail(
        @Path("MOVIE_ID") movieID : Int,
        @Query(PARAM_API_KEY)paramApiKey : String = API_VALUE,
        @Query("append_to_response") appendToResponse : String = "credits") : Observable<MovieDetailVO>


    @GET("movie/{MOVIE_ID}/videos")
    fun getVideo(
        @Path("MOVIE_ID") movieID: Int,
        @Query(PARAM_API_KEY)paramApiKey: String = API_VALUE ) : Observable<VideoResponse>

     @GET("genre/movie/list")
     fun getGenereList(@Query(PARAM_API_KEY)paramApiKey: String) : Observable<GetGenereListResponse>


    @GET("discover/movie")
    fun getMovieByGenre(
        @Query("api_key") paramApiKey: String = API_VALUE,
        @Query("with_genres")genereId : Int) : Observable<GetAllPopularMovieResponse>

}