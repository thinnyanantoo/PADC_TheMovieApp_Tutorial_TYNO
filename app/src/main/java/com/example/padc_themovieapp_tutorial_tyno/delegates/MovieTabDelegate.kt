package com.example.padc_themovieapp_tutorial_tyno.delegates

import com.example.padc_themovieapp_tutorial_tyno.data.vos.PopularMovieVO

interface MovieTabDelegate {
  fun onTapPlay(movieId : Int)
}