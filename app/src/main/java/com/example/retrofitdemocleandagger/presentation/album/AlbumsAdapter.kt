package com.example.retrofitdemocleandagger.presentation.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemocleandagger.R
import com.example.retrofitdemocleandagger.data.model.album.Album
import com.example.retrofitdemocleandagger.databinding.ListItemBinding

class AlbumsAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private val albumList = ArrayList<Album>()

    fun setList(albums: List<Album>){
        albumList.clear()
        albumList.addAll(albums)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(albumList[position])
    }
}

class MyViewHolder(val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root){

    fun bind(album: Album){
        binding.tvAlbumId.text = album.id.toString()
        binding.tvAlbumTitle.text = album.title
        binding.tvUserId.text = album.userId.toString()
    }
}