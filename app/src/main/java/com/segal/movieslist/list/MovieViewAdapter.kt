package com.segal.movieslist.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.segal.movieslist.R
import com.segal.movieslist.model.MovieModel
import kotlinx.android.synthetic.main.item_movie.view.*


private class MoviesDiffUtilCallBack : DiffUtil
.ItemCallback<MovieModel>() {
    override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem.imageRes == newItem.imageRes && oldItem.name == newItem.name && oldItem.overview == newItem.overview
    }

}


class MovieViewAdapter(
    private val movieClickListener: OnMovieClickListener,
    context: Context
) : RecyclerView.Adapter<MovieViewAdapter.ViewHolder>() {

    private val layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private val asyncListDiffer = AsyncListDiffer<MovieModel>(this, MoviesDiffUtilCallBack())

    override fun getItemCount() = asyncListDiffer.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view, movieClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieModel = asyncListDiffer.currentList[position]
        holder.bind(movieModel)
    }


    fun setData(newItems: List<MovieModel>) {
        asyncListDiffer.submitList(newItems)
    }

    fun getCurrentData(): List<MovieModel> {
        return asyncListDiffer.currentList
    }

    fun searchList(searchText: String) {
        val currentData = getCurrentData()
        currentData.filter { movie -> searchText in movie.name }
        setData(currentData)
    }

    inner class ViewHolder(view: View, movieClickListener: OnMovieClickListener) :
        RecyclerView.ViewHolder(view) {
        private val ivImage: ImageView = view.movie_image
        private val tvTitle: TextView = view.title
        private val tvOverview: TextView = view.overview

        private lateinit var movieModel: MovieModel

        init {
            view.setOnClickListener {
                movieClickListener.onMovieClicked(movieModel)
            }
        }

        fun bind(movieModel: MovieModel) {
            ivImage.setImageResource(movieModel.imageRes)
            tvTitle.text = movieModel.name
            tvOverview.text = movieModel.overview

            this.movieModel = movieModel
        }


    }

}

