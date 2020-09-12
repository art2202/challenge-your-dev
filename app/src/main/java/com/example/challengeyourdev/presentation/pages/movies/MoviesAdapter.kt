package com.example.challengeyourdev.presentation.pages.movies

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
import kotlinx.android.synthetic.main.item_movie.view.*


//criado por arthur rodrigues

class MoviesAdapter(
    private val activity : Activity,
    private var listMovies : ArrayList<Movie>,
    private val onFavoriteClick :(movie : Movie) -> Unit) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount() = listMovies.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = listMovies[position]


        holder.itemView.tv_title.text = item.movieTitle
        Picasso.get().load(item.photo.photoUrl).into(holder.itemView.iv_picture)

        holder.itemView.iv_fav.setOnClickListener {
            onFavoriteClick(item)
            notifyDataSetChanged()
        }

        holder.itemView.cr_layout.setOnClickListener {
            val intent = Intent(activity.applicationContext, MovieDetailActivity::class.java)
            intent.putExtra("movie", item)
            activity.startActivity(intent)
        }

        holder.itemView.iv_fav.setImageResource(
            if (item.isFavorite)
                R.drawable.ic_star_accent_24dp
            else
                R.drawable.ic_star_border_accent_24dp
        )

    }

    fun setList(list:ArrayList<Movie>){
        this.listMovies = list
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}