package com.movieappmvvmcleanarchitecture.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.movieappmvvmcleanarchitecture.R
import com.movieappmvvmcleanarchitecture.data.model.artist.Artist
import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.databinding.ListItemBinding

class ArtistAdapter() : RecyclerView.Adapter<ArtistViewHolder>() {
    private var artist = ArrayList<Artist>()
    fun setList(artists: List<Artist>) {
        this.artist.clear()
        this.artist.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistViewHolder(binding)
    }

    override fun getItemCount() = artist.size

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artist[position])
    }

}

class ArtistViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(artist: Artist) {
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = artist.popularity.toString()
        val posterURL = "https://image.tmdb.org/t/p/w500" + artist.profilePath
        Glide.with(binding.root.context)
            .load(posterURL)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .placeholder(R.drawable.placeholder_movieimages)
            .into(binding.imageView)
    }

}