package com.example.retrofitdemocleandagger.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.retrofitdemocleandagger.data.db.AlbumDao
import com.example.retrofitdemocleandagger.data.db.JSONPHDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideAlbumDataBase(context: Context): JSONPHDatabase {
        return Room.databaseBuilder(context,JSONPHDatabase::class.java,"jsonph")
            .build()
    }
    @Singleton
    @Provides
    fun provideAlbumDao(jsonPHDatabase: JSONPHDatabase): AlbumDao {
        return jsonPHDatabase.albumDao()
    }
}