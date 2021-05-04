package com.dapoidev.moviecatalogue.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dapoidev.moviecatalogue.R
import com.dapoidev.moviecatalogue.databinding.ItemMoviesBinding
import com.dapoidev.moviecatalogue.model.data.entity.MovieEntity

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private var listMovies = ArrayList<MovieEntity>()

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies.isNullOrEmpty()) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    inner class MoviesViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            binding.apply {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + movie.image)
                    .transform(RoundedCorners(20))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgMovie)

                tvTitleMovie.text = movie.title
                tvDateMovie.text = movie.date
                tvDescMovie.text = movie.desc

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(movie.id.toString())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) =
        holder.bind(movie = listMovies[position])

    override fun getItemCount(): Int = listMovies.size

    interface OnItemClickCallback {
        fun onItemClicked(id: String)
    }
}