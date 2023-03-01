package com.example.retrofitdemocleandagger.data.repository.album.datasource

import com.example.retrofitdemocleandagger.data.model.album.AlbumList
import retrofit2.Response

interface AlbumRemoteDataSource {

    suspend fun getAlbums(): Response<AlbumList>
}