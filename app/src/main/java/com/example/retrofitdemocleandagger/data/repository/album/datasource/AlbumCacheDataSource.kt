package com.example.retrofitdemocleandagger.data.repository.album.datasource

import com.example.retrofitdemocleandagger.data.model.album.Album

interface AlbumCacheDataSource {

    suspend fun getAlbumsFromCache(): List<Album>

    suspend fun saveAlbumsToCache(albums: List<Album>)
}