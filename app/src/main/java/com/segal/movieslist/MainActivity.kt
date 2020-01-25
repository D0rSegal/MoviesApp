package com.segal.movieslist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.segal.movieslist.details.DetailsFragment
import com.segal.movieslist.list.MoviesFragment
import com.segal.movieslist.list.OnMovieClickListener
import com.segal.movieslist.model.MovieModel

class MainActivity : AppCompatActivity(), OnMovieClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesFragment = MoviesFragment()

        supportFragmentManager.beginTransaction().add(R.id.activity_main_frame, moviesFragment)
            .commit()
    }

    override fun onMovieClicked(movie: MovieModel) {
        val detailsFragment = DetailsFragment.newInstance(movie)
        supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.activity_main_frame, detailsFragment).commit()
    }
}