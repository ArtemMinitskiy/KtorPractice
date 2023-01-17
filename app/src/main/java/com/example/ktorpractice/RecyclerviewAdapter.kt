package com.example.ktorpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ktorpractice.databinding.AdapterMoviesBinding

class RecyclerviewAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private var movieList = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_movies, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movieList.size

    fun setMovieItems(movieList: List<Movie>) {
        this.movieList = movieList.toMutableList()
        notifyDataSetChanged()
    }
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var binding: AdapterMoviesBinding = AdapterMoviesBinding.bind(view)

    fun bind(movie: Movie) {
        binding.apply {
            textTitle.text = movie.name
            Glide.with(itemView.context).load(movie.imageUrl).into(imgImage)
            textDesc.text = movie.desc
            buttonCategory.text = movie.category
        }

    }

}
