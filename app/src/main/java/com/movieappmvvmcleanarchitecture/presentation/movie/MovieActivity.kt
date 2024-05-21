package com.movieappmvvmcleanarchitecture.presentation.movie

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.movieappmvvmcleanarchitecture.R
import com.movieappmvvmcleanarchitecture.databinding.ActivityMovieBinding
import com.movieappmvvmcleanarchitecture.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory

    lateinit var movieViewModel: MovieViewModel

    lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createMovieSubComponent().inject(this)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        movieViewModel.getMovies().observe(this) {
            Log.d("MyTag", it.toString())
        }
    }
}