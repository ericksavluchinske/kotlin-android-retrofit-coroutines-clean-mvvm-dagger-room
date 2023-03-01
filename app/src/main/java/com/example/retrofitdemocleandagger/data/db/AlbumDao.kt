package com.example.retrofitdemocleandagger.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitdemocleandagger.data.model.album.Album

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAlbums(albums: List<Album>)

    @Query("DELETE FROM albums_table")
    suspend fun deleteAllAlbums()

    @Query("SELECT * FROM albums_table")
    suspend fun getAlbums(): List<Album>
}