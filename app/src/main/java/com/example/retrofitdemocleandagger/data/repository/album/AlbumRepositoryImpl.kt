package com.example.retrofitdemocleandagger.data.repository.album

import android.util.Log
import com.example.retrofitdemocleandagger.data.model.album.Album
import com.example.retrofitdemocleandagger.data.repository.album.datasource.AlbumCacheDataSource
import com.example.retrofitdemocleandagger.data.repository.album.datasource.AlbumLocalDataSource
import com.example.retrofitdemocleandagger.data.repository.album.datasource.AlbumRemoteDataSource
import com.example.retrofitdemocleandagger.domain.repository.AlbumRepository

class AlbumRepositoryImpl(
    private val albumRemoteDataSource: AlbumRemoteDataSource,
    private val albumLocalDataSource: AlbumLocalDataSource,
    private val albumCacheDataSource: AlbumCacheDataSource
): AlbumRepository {
    override suspend fun getAlbums(): List<Album>? {
        return getAlbumsFromCache()
    }

    override suspend fun updateAlbums(): List<Album>? {
        val newListOfAlbums = getAlbumsFromAPI()
        albumLocalDataSource.clearAll()
        albumLocalDataSource.saveAlbumsToDB(newListOfAlbums)
        albumCacheDataSource.saveAlbumsToCache(newListOfAlbums)
        return newListOfAlbums
    }

    suspend fun getAlbumsFromCache(): List<Album>{
        lateinit var albumList: List<Album>
        try {
            albumList = albumCacheDataSource.getAlbumsFromCache()
        }catch (exception: Exception){
            Log.i("REPO_CACHE", exception.message.toString())
        }

        if (albumList.size > 0){
            return albumList
        }else{
            albumList = getAlbumsFromDB()
            albumCacheDataSource.saveAlbumsToCache(albumList)
        }
        return albumList
    }

    suspend fun getAlbumsFromDB(): List<Album>{
        lateinit var albumList: List<Album>
        try {
            albumList = albumLocalDataSource.getAlbumsFromDB()
        }catch (exception: Exception){
            Log.i("REPO_LOCAL", exception.message.toString())
        }
        if (albumList.size>0){
            return albumList
        }else{
            albumList = getAlbumsFromAPI()
            albumLocalDataSource.saveAlbumsToDB(albumList)
        }

        return albumList
    }

    suspend fun getAlbumsFromAPI(): List<Album>{
        lateinit var albumList: List<Album>
        try {
            val response = albumRemoteDataSource.getAlbums()
            val body = response.body()
            if (body != null){
                albumList = body
            }
        }catch (exception: Exception){
            Log.i("REPO_REMOTE", exception.message.toString())
        }
        return albumList
    }

}