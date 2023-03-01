package com.example.retrofitdemocleandagger.data.repository.album.datasource

import com.example.retrofitdemocleandagger.data.model.album.Album

interface AlbumLocalDataSource {

    suspend fun getAlbumsFromDB(): List<Album>

    suspend fun saveAlbumsToDB(albums: List<Album>)

    suspend fun clearAll()
}