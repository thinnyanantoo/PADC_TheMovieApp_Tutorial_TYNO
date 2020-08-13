package com.example.padc_themovieapp_tutorial_tyno.utiils

import android.graphics.Movie
import com.example.padc_themovieapp_tutorial_tyno.BuildConfig
import com.example.padc_themovieapp_tutorial_tyno.data.vos.*


const val BASE_POPULAR_URL =BuildConfig.BASE_POPULAR_URL

const val GET_POPULAR_MOVIE="movie/popular"
const val GET_ACTOR = "person/popular"

const val GET_MOVIES = "movie"

const val PARAM_API_KEY= "api_key"

//const val API_VALUE = "b3f4ac68fcb0df03dafac748cba279a1"
const val API_VALUE = BuildConfig.MY_API.toString()

const val EM_NO_INTERNET_CONNECTION = "No Internet Connection"

const val EM_NO_MOVIES_AVAILABLE = "There are no news available"

const val EMPTY_IMAGE_URL = "https://point-broadband.com/wp-content/uploads/2017/06/No-data-caps-graphic-e1497904686711.png"


const val IMAGE_URL = "https://image.tmdb.org/t/p/"

const val GET_LIST = "movie/top_rated"

const val GET_UPCOMMING_MOVIE_ID = "movie/upcoming"

fun getDummyPopularMovies(): List<PopularMovieVO>{
    val popularList = mutableListOf<PopularMovieVO>()
    for (i in 1..100)
    popularList.add(PopularMovieVO(2.4,1,true,"https://www.posterpath",i,false,"https://www.backdropPath","English","Movie",ArrayList(21),"The Moon",12.1,"Good Drama","12/10/201") )
    return  popularList
}

fun getDummyActorList(): List<BestActorVO>{
    val actorList = mutableListOf<BestActorVO>()
    for(i in 1..100)
        actorList.add(BestActorVO(1.2,"know for department",1,i,"https://www.posterPath",true,ArrayList(1),"Jung Kook"))
            return actorList
}

fun getDummyAllGenere(): List<GenereVO>{
    val genereList = mutableListOf<GenereVO>()
    for(i in 1 ..15000)
        genereList.add(GenereVO(i,"Drama"))
    return genereList
}

fun getDummyVideo(movieId: Int) : VideoVO{
   return  VideoVO(movieId.toString(),"iso63", "iso31","23", "BlueMoon", "25",movieId,"drama")

}

fun getDummyMovieDetail(movieId: Int): MovieDetailVO{
  return MovieDetailVO(true,"https://www.backdropPath", emptyList(),movieId,"Running Man","Good Variety Show","99.2","https://www.posterPath", emptyList(),"12/2/2012",10)
    }





