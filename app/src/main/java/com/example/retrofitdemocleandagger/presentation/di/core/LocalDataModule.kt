package com.example.retrofitdemocleandagger.presentation.di.core

import com.example.retrofitdemocleandagger.data.db.AlbumDao
import com.example.retrofitdemocleandagger.data.repository.album.datasource.AlbumLocalDataSource
import com.example.retrofitdemocleandagger.data.repository.album.datasourceImpl.AlbumLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideAlbumLocalDataSource(albumDao: AlbumDao): AlbumLocalDataSource {
        return AlbumLocalDataSourceImpl(albumDao)
    }
}