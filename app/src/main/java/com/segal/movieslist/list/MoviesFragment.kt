package com.segal.movieslist.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.segal.movieslist.R
import com.segal.movieslist.model.MovieModel


class MoviesFragment : Fragment(), OnMovieClickListener {

    private var listener: OnMovieClickListener? = null
    private val movies: MutableList<MovieModel> = ArrayList()
    private lateinit var moviesAdapter: MovieViewAdapter
    private lateinit var moviesRcv: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        moviesRcv = view.findViewById(R.id.movies_fragment_rcv)
        loadMovies(movies)
        initRecyclerView()
        // TODO: impalement search function using MovieListAdapter
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnMovieClickListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun initRecyclerView() {
        context?.let {
            moviesAdapter = MovieViewAdapter(
                context = it,
                movieClickListener = this@MoviesFragment
            )
            moviesRcv.layoutManager = LinearLayoutManager(it)
            moviesRcv.adapter = moviesAdapter
            moviesAdapter.setData(movies)
        }
    }

    override fun onMovieClicked(movie: MovieModel) {
        listener?.onMovieClicked(movie)
    }


    private fun loadMovies(movies: MutableList<MovieModel>) {
        movies.add(
            MovieModel(
                "Iron man 1",
                R.drawable.ironman1,
                "Tony Stark. Genius, billionaire, playboy, philanthropist. Son of legendary inventor and weapons contractor Howard Stark. When Tony Stark is assigned to give a weapons presentation to an Iraqi unit led by Lt. Col. James Rhodes, he's given a ride on enemy lines. That ride ends badly when Stark's Humvee that he's riding in is attacked by enemy combatants. He survives - barely - with a chest full of shrapnel and a car battery attached to his heart. In order to survive he comes up with a way to miniaturize the battery and figures out that the battery can power something else. Thus Iron Man is born. He uses the primitive device to escape from the cave in Iraq. Once back home, he then begins work on perfecting the Iron Man suit. But the man who was put in charge of Stark Industries has plans of his own to take over Tony's technology for other matters",
                "vMBXp5h1yCw",
                "02-05-2008"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 2",
                R.drawable.ironman2,
                "With the world now aware of his dual life as the armored superhero Iron Man, billionaire inventor Tony Stark faces pressure from the government, the press, and the public to share his technology with the military. Unwilling to let go of his invention, Stark, along with Pepper Potts, and James \"Rhodey\" Rhodes at his side, must forge new alliances - and confront powerful enemies",
                "ZALHeuKyS9A",
                "07-05-2010"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 3",
                R.drawable.ironman3,
                "Marvel's Iron Man 3 pits brash-but-brilliant industrialist Tony Stark/Iron Man against an enemy whose reach knows no bounds. When Stark finds his personal world destroyed at his enemy's hands, he embarks on a harrowing quest to find those responsible. This journey, at every turn, will test his mettle. With his back against the wall, Stark is left to survive by his own devices, relying on his ingenuity and instincts to protect those closest to him. As he fights his way back, Stark discovers the answer to the question that has secretly haunted him: does the man make the suit or does the suit make the man",
                "Ke1Y3P9D0Bc",
                "03-05-2013"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 1",
                R.drawable.ironman1,
                "Tony Stark. Genius, billionaire, playboy, philanthropist. Son of legendary inventor and weapons contractor Howard Stark. When Tony Stark is assigned to give a weapons presentation to an Iraqi unit led by Lt. Col. James Rhodes, he's given a ride on enemy lines. That ride ends badly when Stark's Humvee that he's riding in is attacked by enemy combatants. He survives - barely - with a chest full of shrapnel and a car battery attached to his heart. In order to survive he comes up with a way to miniaturize the battery and figures out that the battery can power something else. Thus Iron Man is born. He uses the primitive device to escape from the cave in Iraq. Once back home, he then begins work on perfecting the Iron Man suit. But the man who was put in charge of Stark Industries has plans of his own to take over Tony's technology for other matters",
                "vMBXp5h1yCw",
                "02-05-2008"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 2",
                R.drawable.ironman2,
                "With the world now aware of his dual life as the armored superhero Iron Man, billionaire inventor Tony Stark faces pressure from the government, the press, and the public to share his technology with the military. Unwilling to let go of his invention, Stark, along with Pepper Potts, and James \"Rhodey\" Rhodes at his side, must forge new alliances - and confront powerful enemies",
                "ZALHeuKyS9A",
                "07-05-2010"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 3",
                R.drawable.ironman3,
                "Marvel's Iron Man 3 pits brash-but-brilliant industrialist Tony Stark/Iron Man against an enemy whose reach knows no bounds. When Stark finds his personal world destroyed at his enemy's hands, he embarks on a harrowing quest to find those responsible. This journey, at every turn, will test his mettle. With his back against the wall, Stark is left to survive by his own devices, relying on his ingenuity and instincts to protect those closest to him. As he fights his way back, Stark discovers the answer to the question that has secretly haunted him: does the man make the suit or does the suit make the man",
                "Ke1Y3P9D0Bc",
                "03-05-2013"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 1",
                R.drawable.ironman1,
                "Tony Stark. Genius, billionaire, playboy, philanthropist. Son of legendary inventor and weapons contractor Howard Stark. When Tony Stark is assigned to give a weapons presentation to an Iraqi unit led by Lt. Col. James Rhodes, he's given a ride on enemy lines. That ride ends badly when Stark's Humvee that he's riding in is attacked by enemy combatants. He survives - barely - with a chest full of shrapnel and a car battery attached to his heart. In order to survive he comes up with a way to miniaturize the battery and figures out that the battery can power something else. Thus Iron Man is born. He uses the primitive device to escape from the cave in Iraq. Once back home, he then begins work on perfecting the Iron Man suit. But the man who was put in charge of Stark Industries has plans of his own to take over Tony's technology for other matters",
                "vMBXp5h1yCw",
                "02-05-2008"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 2",
                R.drawable.ironman2,
                "With the world now aware of his dual life as the armored superhero Iron Man, billionaire inventor Tony Stark faces pressure from the government, the press, and the public to share his technology with the military. Unwilling to let go of his invention, Stark, along with Pepper Potts, and James \"Rhodey\" Rhodes at his side, must forge new alliances - and confront powerful enemies",
                "ZALHeuKyS9A",
                "07-05-2010"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 3",
                R.drawable.ironman3,
                "Marvel's Iron Man 3 pits brash-but-brilliant industrialist Tony Stark/Iron Man against an enemy whose reach knows no bounds. When Stark finds his personal world destroyed at his enemy's hands, he embarks on a harrowing quest to find those responsible. This journey, at every turn, will test his mettle. With his back against the wall, Stark is left to survive by his own devices, relying on his ingenuity and instincts to protect those closest to him. As he fights his way back, Stark discovers the answer to the question that has secretly haunted him: does the man make the suit or does the suit make the man",
                "Ke1Y3P9D0Bc",
                "03-05-2013"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 1",
                R.drawable.ironman1,
                "Tony Stark. Genius, billionaire, playboy, philanthropist. Son of legendary inventor and weapons contractor Howard Stark. When Tony Stark is assigned to give a weapons presentation to an Iraqi unit led by Lt. Col. James Rhodes, he's given a ride on enemy lines. That ride ends badly when Stark's Humvee that he's riding in is attacked by enemy combatants. He survives - barely - with a chest full of shrapnel and a car battery attached to his heart. In order to survive he comes up with a way to miniaturize the battery and figures out that the battery can power something else. Thus Iron Man is born. He uses the primitive device to escape from the cave in Iraq. Once back home, he then begins work on perfecting the Iron Man suit. But the man who was put in charge of Stark Industries has plans of his own to take over Tony's technology for other matters",
                "vMBXp5h1yCw",
                "02-05-2008"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 2",
                R.drawable.ironman2,
                "With the world now aware of his dual life as the armored superhero Iron Man, billionaire inventor Tony Stark faces pressure from the government, the press, and the public to share his technology with the military. Unwilling to let go of his invention, Stark, along with Pepper Potts, and James \"Rhodey\" Rhodes at his side, must forge new alliances - and confront powerful enemies",
                "ZALHeuKyS9A",
                "07-05-2010"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 3",
                R.drawable.ironman3,
                "Marvel's Iron Man 3 pits brash-but-brilliant industrialist Tony Stark/Iron Man against an enemy whose reach knows no bounds. When Stark finds his personal world destroyed at his enemy's hands, he embarks on a harrowing quest to find those responsible. This journey, at every turn, will test his mettle. With his back against the wall, Stark is left to survive by his own devices, relying on his ingenuity and instincts to protect those closest to him. As he fights his way back, Stark discovers the answer to the question that has secretly haunted him: does the man make the suit or does the suit make the man",
                "Ke1Y3P9D0Bc",
                "03-05-2013"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 1",
                R.drawable.ironman1,
                "Tony Stark. Genius, billionaire, playboy, philanthropist. Son of legendary inventor and weapons contractor Howard Stark. When Tony Stark is assigned to give a weapons presentation to an Iraqi unit led by Lt. Col. James Rhodes, he's given a ride on enemy lines. That ride ends badly when Stark's Humvee that he's riding in is attacked by enemy combatants. He survives - barely - with a chest full of shrapnel and a car battery attached to his heart. In order to survive he comes up with a way to miniaturize the battery and figures out that the battery can power something else. Thus Iron Man is born. He uses the primitive device to escape from the cave in Iraq. Once back home, he then begins work on perfecting the Iron Man suit. But the man who was put in charge of Stark Industries has plans of his own to take over Tony's technology for other matters",
                "vMBXp5h1yCw",
                "02-05-2008"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 2",
                R.drawable.ironman2,
                "With the world now aware of his dual life as the armored superhero Iron Man, billionaire inventor Tony Stark faces pressure from the government, the press, and the public to share his technology with the military. Unwilling to let go of his invention, Stark, along with Pepper Potts, and James \"Rhodey\" Rhodes at his side, must forge new alliances - and confront powerful enemies",
                "ZALHeuKyS9A",
                "07-05-2010"
            )
        )
        movies.add(
            MovieModel(
                "Iron man 3",
                R.drawable.ironman3,
                "Marvel's Iron Man 3 pits brash-but-brilliant industrialist Tony Stark/Iron Man against an enemy whose reach knows no bounds. When Stark finds his personal world destroyed at his enemy's hands, he embarks on a harrowing quest to find those responsible. This journey, at every turn, will test his mettle. With his back against the wall, Stark is left to survive by his own devices, relying on his ingenuity and instincts to protect those closest to him. As he fights his way back, Stark discovers the answer to the question that has secretly haunted him: does the man make the suit or does the suit make the man",
                "Ke1Y3P9D0Bc",
                "03-05-2013"
            )
        )

    }
}