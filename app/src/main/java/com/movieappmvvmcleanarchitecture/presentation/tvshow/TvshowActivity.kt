package com.movieappmvvmcleanarchitecture.presentation.tvshow

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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.movieappmvvmcleanarchitecture.R
import com.movieappmvvmcleanarchitecture.databinding.ActivityMovieBinding
import com.movieappmvvmcleanarchitecture.databinding.ActivityTvshowBinding
import com.movieappmvvmcleanarchitecture.presentation.di.Injector
import com.movieappmvvmcleanarchitecture.presentation.movie.MovieAdapter
import com.movieappmvvmcleanarchitecture.presentation.movie.MovieViewModel
import com.movieappmvvmcleanarchitecture.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class TvshowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvshowViewModelFactory

    lateinit var tvshowViewModel: TvshowViewModel

    lateinit var tvshowAdapter: TvshowAdapter

    lateinit var binding: ActivityTvshowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTvshowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        (application as Injector).createTvSubComponent().inject(this)

        tvshowViewModel = ViewModelProvider(this, factory).get(TvshowViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        //progressbar loading
        binding.tvShowProgressbar.visibility = View.VISIBLE

        binding.tvshowRecyclerView.layoutManager = LinearLayoutManager(this)
        tvshowAdapter = TvshowAdapter()
        binding.tvshowRecyclerView.adapter = tvshowAdapter
        displayPopularTvshow()
    }

    private fun displayPopularTvshow() {
        val tvshowLiveData = tvshowViewModel.getTvShows()
        tvshowLiveData.observe(this) {
            Log.d("MyTag", "list: $it")
            if (it != null) {
                tvshowAdapter.setList(it)
                tvshowAdapter.notifyDataSetChanged()
                binding.tvShowProgressbar.visibility = View.GONE //progress gone
            } else {
                binding.tvShowProgressbar.visibility = View.GONE
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
                updateTvshow()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateTvshow() {
        Toast.makeText(applicationContext, "Trying To Update Tvshow", Toast.LENGTH_LONG)
            .show()
        binding.tvShowProgressbar.visibility = View.VISIBLE
        val updatedTvshowsResponse = tvshowViewModel.updateTvShows()
        updatedTvshowsResponse.observe(this) {
            if (it != null) {
                tvshowAdapter.setList(it)
                tvshowAdapter.notifyDataSetChanged()
                binding.tvShowProgressbar.visibility = View.GONE
            } else {
                binding.tvShowProgressbar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available to update", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}