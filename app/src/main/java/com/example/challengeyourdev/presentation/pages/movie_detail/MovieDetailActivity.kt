package com.example.challengeyourdev.presentation.pages.movie_detail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeyourdev.R
import com.example.challengeyourdev.core.utils.DateFormatUtils
import com.example.challengeyourdev.domain.entities.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MovieDetailActivity : AppCompatActivity() {

    private val viewModel : MovieDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val data = intent.extras
        if(data != null){
            val movie = data.getSerializable("movie")  as Movie
            setDateInScreen(movie)
        }
        iv_back.setOnClickListener { onBackPressed() }
    }

    private fun setDateInScreen(movie: Movie){

        val dateFormat = DateFormatUtils()

        if(movie.photo.photoUrl.isNotEmpty())
            Picasso.get().load(movie.photo.photoUrl).fit().into(iv_picture)
        tv_title.text = movie.movieTitle
        tv_resume.text = movie.summaryShort
        tv_author_critic.text = "Review by: ${movie.criticAuthor} | ${dateFormat(movie.publicationDate)}"
        tv_critic_resume.text = movie.link.suggestedText
        setImageFavorite(movie)
        iv_favorite.setOnClickListener {
            onFavoriteClick(movie)
            movie.isFavorite = !movie.isFavorite
            setImageFavorite(movie)
        }



        fab.setOnClickListener { sharedCritic(movie.link.criticUrl) }
        tv_view_more.setOnClickListener { openChrome(movie.link.criticUrl) }
    }

    private fun setImageFavorite(movie: Movie){

        iv_favorite.setImageResource(
            if (movie.isFavorite)
                R.drawable.ic_star_white
            else
                R.drawable.ic_star_border_white
        )
    }
    private fun onFavoriteClick(movie: Movie) {
        viewModel.favoriteOrDisfavorMovie(movie)
    }

    private fun sharedCritic(url: String){

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