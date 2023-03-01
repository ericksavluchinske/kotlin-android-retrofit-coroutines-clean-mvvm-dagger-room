package com.example.retrofitdemocleandagger.data.repository.album.datasourceImpl

import com.example.retrofitdemocleandagger.data.model.album.Album
import com.example.retrofitdemocleandagger.data.repository.album.datasource.AlbumCacheDataSource

class AlbumCacheDataSourceImpl: AlbumCacheDataSource {

    private var albumList = ArrayList<Album>()

    override suspend fun getAlbumsFromCache(): List<Album> {
        return albumList
    }

    override suspend fun saveAlbumsToCache(albums: List<Album>) {
        albumList.clear()
        albumList = ArrayList(albums)
    }
}