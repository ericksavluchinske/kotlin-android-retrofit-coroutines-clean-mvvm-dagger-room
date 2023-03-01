package com.example.retrofitdemocleandagger.data.api

import com.example.retrofitdemocleandagger.data.model.album.AlbumList
import retrofit2.Response
import retrofit2.http.GET

interface JSONPlaceHolderService {

    @GET("/albums")
    suspend fun getAlbums(): Response<AlbumList>
}