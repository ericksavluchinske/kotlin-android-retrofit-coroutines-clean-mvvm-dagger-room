package com.example.retrofitdemocleandagger.data.repository.album.datasourceImpl

import com.example.retrofitdemocleandagger.data.api.JSONPlaceHolderService
import com.example.retrofitdemocleandagger.data.model.album.AlbumList
import com.example.retrofitdemocleandagger.data.repository.album.datasource.AlbumRemoteDataSource
import retrofit2.Response

class AlbumRemoteDataSourceImpl(
    private val jsonPlaceHolderService: JSONPlaceHolderService,
): AlbumRemoteDataSource {
    override suspend fun getAlbums(): Response<AlbumList> = jsonPlaceHolderService.getAlbums()

}