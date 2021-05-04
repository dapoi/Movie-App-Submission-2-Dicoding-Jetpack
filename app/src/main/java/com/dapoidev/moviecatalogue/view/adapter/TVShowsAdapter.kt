package com.dapoidev.moviecatalogue.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dapoidev.moviecatalogue.R
import com.dapoidev.moviecatalogue.databinding.ItemTvShowsBinding
import com.dapoidev.moviecatalogue.model.data.entity.TVShowEntity

class TVShowsAdapter : RecyclerView.Adapter<TVShowsAdapter.TVShowViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private var listTVShows = ArrayList<TVShowEntity>()

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setTVShow(tvShows: List<TVShowEntity>?) {
        if (tvShows.isNullOrEmpty()) return
        this.listTVShows.clear()
        this.listTVShows.addAll(tvShows)
    }

    inner class TVShowViewHolder(private val binding: ItemTvShowsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TVShowEntity) {
            binding.apply {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + tvShow.image)
                    .transform(RoundedCorners(20))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgShows)

                tvTitleShows.text = tvShow.title
                tvDateShows.text = tvShow.date
                tvDescShows.text = tvShow.desc

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(tvShow.id.toString())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val view = ItemTvShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) =
        holder.bind(tvShow = listTVShows[position])


    override fun getItemCount(): Int = listTVShows.size

    interface OnItemClickCallback {
        fun onItemClicked(id: String)
    }
}