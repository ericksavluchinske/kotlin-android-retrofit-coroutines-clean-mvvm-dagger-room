package com.example.retrofitdemocleandagger.domain.repository

import com.example.retrofitdemocleandagger.data.model.album.Album

interface AlbumRepository {

    suspend fun getAlbums(): List<Album>?

    suspend fun updateAlbums(): List<Album>?
}