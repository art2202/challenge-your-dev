package com.example.challengeyourdev.presentation.pages.movie_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challengeyourdev.R
import com.example.challengeyourdev.domain.entities.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val data = intent.extras
        if(data != null){
            val movie = data.getSerializable("movie")  as Movie
            setDateInScreen(movie)
        }
    }

    private fun setDateInScreen(movie : Movie){

        Picasso.get().load(movie.photo.photoUrl).resize(600, 400).into(iv_picture)
        tv_title.text = movie.movieTitle
        tv_date.text = movie.publicationDate
        tv_resume.text = movie.summaryShort
        
    }
}