package com.example.challengeyourdev.presentation.pages.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeyourdev.R
import com.example.challengeyourdev.domain.entities.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*


//criado por arthur rodrigues

class MoviesAdapter(private var listMovies : ArrayList<Movie>) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount() = listMovies.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = listMovies[position]

        holder.itemView.tv_title.text = item.movieTitle
        Picasso.get().load(item.photoUrl).into(holder.itemView.iv_picture)

    }

    fun addItems(list: ArrayList<Movie>) {
        this.listMovies.addAll(list)
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}