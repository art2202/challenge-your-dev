package com.example.challengeyourdev.presentation.pages.movie_detail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

    private fun setDateInScreen(movie: Movie){

        Picasso.get().load(movie.photo.photoUrl).resize(600, 400).into(iv_picture)
        tv_title.text = movie.movieTitle
        tv_date.text = movie.publicationDate
        tv_resume.text = movie.summaryShort
        fab.setOnClickListener { sharedCritic(movie.link.criticUrl) }

    }

    private fun sharedCritic(url : String){

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, url)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)

    }
    private fun openChrome(url: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.android.chrome")
        try {
            startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            intent.setPackage(null)
            startActivity(intent)
        }
    }
}