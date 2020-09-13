package com.example.challengeyourdev.presentation.pages.favorite_movies

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeyourdev.R
import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.presentation.pages.movie_detail.MovieDetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie_favorite.view.*
import kotlinx.android.synthetic.main.item_movie_favorite.view.tv_title


//criado por arthur rodrigues

class FavoriteMoviesAdapter(
    private val activity : Activity,
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
        if(item.photo.photoUrl.isNotEmpty())
            Picasso.get().load(item.photo.photoUrl).fit().into(holder.itemView.iv_poster)
        holder.itemView.tv_release_date.text = item.publicationDate

        holder.itemView.cr_layout.setOnClickListener {
            val intent = Intent(activity.applicationContext, MovieDetailActivity::class.java)
            intent.putExtra("movie", item)
            activity.startActivity(intent)
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}