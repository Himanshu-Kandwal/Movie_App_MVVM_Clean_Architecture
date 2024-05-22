package com.movieappmvvmcleanarchitecture.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.movieappmvvmcleanarchitecture.R
import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShow
import com.movieappmvvmcleanarchitecture.databinding.ListItemBinding

class TvshowAdapter() : RecyclerView.Adapter<TvshowViewHolder>() {
    private var tvShows = ArrayList<TvShow>()
    fun setList(tvShowslist: List<TvShow>) {
        this.tvShows.clear()
        this.tvShows.addAll(tvShowslist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvshowViewHolder(binding)
    }

    override fun getItemCount() = tvShows.size

    override fun onBindViewHolder(holder: TvshowViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

}

class TvshowViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tvshow: TvShow) {
        binding.titleTextView.text = tvshow.name
        binding.descriptionTextView.text = tvshow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500" + tvshow.posterPath
        Glide.with(binding.root.context)
            .load(posterURL)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .placeholder(R.drawable.placeholder_movieimages)
            .into(binding.imageView)
    }

}