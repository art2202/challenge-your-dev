package com.example.challengeyourdev.presentation.pages.movies

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeyourdev.domain.entities.Movie


//criado por balanike

class MoviesAdapter(private var listMovies : ArrayList<Movie>) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = listMovies.size

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}