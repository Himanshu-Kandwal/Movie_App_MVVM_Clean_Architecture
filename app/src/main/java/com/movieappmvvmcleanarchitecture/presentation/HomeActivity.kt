package com.movieappmvvmcleanarchitecture.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.movieappmvvmcleanarchitecture.R
import com.movieappmvvmcleanarchitecture.databinding.ActivityHomeBinding
import com.movieappmvvmcleanarchitecture.presentation.artist.ArtistActivity
import com.movieappmvvmcleanarchitecture.presentation.movie.MovieActivity
import com.movieappmvvmcleanarchitecture.presentation.tvshow.TvshowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //data binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.movieButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, MovieActivity::class.java))
        }

        binding.artistButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, ArtistActivity::class.java))

        }

        binding.tvShowButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, TvshowActivity::class.java))

        }
    }
}