package com.movieappmvvmcleanarchitecture.presentation.movie

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.movieappmvvmcleanarchitecture.R
import com.movieappmvvmcleanarchitecture.databinding.ActivityMovieBinding
import com.movieappmvvmcleanarchitecture.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory

    lateinit var movieViewModel: MovieViewModel

    lateinit var binding: ActivityMovieBinding
    lateinit var movieAdapter: MovieAdapter

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

        initRecyclerView()
    }

    private fun initRecyclerView() {
        //progressbar loading
        binding.movieProgressBar.visibility = View.VISIBLE

        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter()
        binding.movieRecyclerView.adapter = movieAdapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        val moviesLiveData = movieViewModel.getMovies()
        moviesLiveData.observe(this) {
            Log.d("MyTag", "list: $it")
            if (it != null) {
                movieAdapter.setList(it)
                movieAdapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE //progress gone
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateMovies() {
        Toast.makeText(applicationContext, "Trying To Update movie", Toast.LENGTH_LONG)
            .show()
        binding.movieProgressBar.visibility = View.VISIBLE
        val updatedMovieResponse = movieViewModel.updateMovies()
        updatedMovieResponse.observe(this) {
            if (it != null) {
                movieAdapter.setList(it)
                movieAdapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available to update", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}