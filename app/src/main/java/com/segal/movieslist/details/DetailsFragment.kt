package com.segal.movieslist.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.segal.movieslist.R
import com.segal.movieslist.model.MovieModel
import java.io.Serializable

class DetailsFragment : Fragment() {

    private lateinit var posterImage: ImageView
    private lateinit var titleText: TextView
    private lateinit var releaseDateText: TextView
    private lateinit var trailerButton: Button
    private lateinit var overviewText: TextView
    private lateinit var youtubeId: String

    companion object {

        private const val MOVIE_BUNDLE_KEY = "movie"
        fun newInstance(movie: MovieModel): DetailsFragment {

            val fragment = DetailsFragment()
            val args = Bundle()
            args.putSerializable(MOVIE_BUNDLE_KEY, movie)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_details, container, false)
        val movie: MovieModel? = arguments?.getSerializable(MOVIE_BUNDLE_KEY) as MovieModel?

        initViews(view)
        movie?.let(::loadMovie)

        return view
    }

    private fun openTrailer() {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:${youtubeId}"))
        startActivity(appIntent)
    }

    private fun initViews(view: View) {
        posterImage = view.findViewById(R.id.sideImage)
        titleText = view.findViewById(R.id.movieTitleText)
        releaseDateText = view.findViewById(R.id.releaseDateText)
        trailerButton = view.findViewById(R.id.youtubeLinkBtn)
        overviewText = view.findViewById(R.id.overviewContentText)
        trailerButton.setOnClickListener { openTrailer() }

    }

    private fun loadMovie(movie: MovieModel) {
        posterImage.setImageResource(movie.imageRes)
        titleText.text = movie.name
        releaseDateText.text = movie.releaseDate
        overviewText.text = movie.overview
        youtubeId = movie.youtubeId
    }
}