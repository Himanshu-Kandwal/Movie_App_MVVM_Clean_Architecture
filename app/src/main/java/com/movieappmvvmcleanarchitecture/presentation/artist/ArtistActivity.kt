package com.movieappmvvmcleanarchitecture.presentation.artist

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
import com.movieappmvvmcleanarchitecture.databinding.ActivityArtistBinding
import com.movieappmvvmcleanarchitecture.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewmodelFactory

    lateinit var artistViewmodel: ArtistViewmodel

    lateinit var artistAdapter: ArtistAdapter

    lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        (application as Injector).createArtistSubComponent().inject(this)
        artistViewmodel = ViewModelProvider(this, factory).get(ArtistViewmodel::class.java)

        initRecyclerView()

    }


    private fun initRecyclerView() {
        //progressbar loading
        binding.artistProgressBar.visibility = View.VISIBLE

        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        artistAdapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = artistAdapter
        displayPopularArtist()
    }

    private fun displayPopularArtist() {
        val artistsLiveData = artistViewmodel.getArtists()
        artistsLiveData.observe(this) {
            Log.d("MyTag", "list: $it")
            if (it != null) {
                artistAdapter.setList(it)
                artistAdapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE //progress gone
            } else {
                binding.artistProgressBar.visibility = View.GONE
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
                updateArtist()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateArtist() {
        Toast.makeText(applicationContext, "Trying To Update Artist", Toast.LENGTH_LONG)
            .show()
        binding.artistProgressBar.visibility = View.VISIBLE
        val updatedartistResponse = artistViewmodel.updateArtists()
        updatedartistResponse.observe(this) {
            if (it != null) {
                artistAdapter.setList(it)
                artistAdapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available to update", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

}