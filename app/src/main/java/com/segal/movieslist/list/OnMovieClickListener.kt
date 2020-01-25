package com.segal.movieslist.list

import com.segal.movieslist.model.MovieModel

interface OnMovieClickListener {
    fun onMovieClicked(movie: MovieModel)
}