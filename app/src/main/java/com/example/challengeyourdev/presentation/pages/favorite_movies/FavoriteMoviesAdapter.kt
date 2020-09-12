package com.example.challengeyourdev.presentation.pages.favorite_movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeyourdev.R
import com.example.challengeyourdev.domain.entities.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie_favorite.view.*
import kotlinx.android.synthetic.main.item_movie_favorite.view.tv_title


//criado por arthur rodrigues

class FavoriteMoviesAdapter(
    private val listFavoriteMovies : ArrayList<Movie>,
    private val onFavoriteClick : (movie : Movie) -> Unit) : RecyclerView.Adapter<FavoriteMoviesAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie_favorite, parent, false))
    }

    override fun getItemCount(): Int =listFavoriteMovies.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listFavoriteMovies[position]

        holder.itemView.tv_title.text = item.movieTitle
        holder.itemView.tv_resume.text = item.summaryShort
        Picasso.get().load(item.photo.photoUrl).into(holder.itemView.iv_poster)
        holder.itemView.tv_release_date.text = item.publicationDate
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}