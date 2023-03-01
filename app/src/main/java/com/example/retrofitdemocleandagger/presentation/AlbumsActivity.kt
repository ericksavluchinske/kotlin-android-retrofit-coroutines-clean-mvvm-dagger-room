package com.example.retrofitdemocleandagger.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemocleandagger.R
import com.example.retrofitdemocleandagger.databinding.ActivityAlbumsBinding
import com.example.retrofitdemocleandagger.presentation.album.AlbumsAdapter
import com.example.retrofitdemocleandagger.presentation.album.AlbumsViewModel
import com.example.retrofitdemocleandagger.presentation.album.AlbumsViewModelFactory
import com.example.retrofitdemocleandagger.presentation.di.Injector
import javax.inject.Inject

class AlbumsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: AlbumsViewModelFactory
    private lateinit var albumsViewModel: AlbumsViewModel
    private lateinit var binding: ActivityAlbumsBinding
    private lateinit var adapter: AlbumsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_albums)
        (application as Injector).createAlbumSubComponent()
            .inject(this)
        albumsViewModel = ViewModelProvider(this, factory)
            .get(AlbumsViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.albumsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AlbumsAdapter()
        binding.albumsRecyclerView.adapter = adapter
        displayAlbums()
    }

    private fun displayAlbums() {
        binding.albumsProgressBar.visibility = View.VISIBLE
        val responseLiveData = albumsViewModel.getAlbums()
        responseLiveData.observe(this, Observer {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.albumsProgressBar.visibility = View.GONE
            }else{
                binding.albumsProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun updateAlbums(){
        binding.albumsProgressBar.visibility = View.VISIBLE
        val response = albumsViewModel.updateAlbums()
        response.observe(this, Observer {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.albumsProgressBar.visibility = View.GONE
            }else{
                binding.albumsProgressBar.visibility = View.GONE
            }
        })
    }
}