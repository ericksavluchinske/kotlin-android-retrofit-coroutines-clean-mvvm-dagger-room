package com.example.retrofitdemocleandagger.presentation.di.core

import com.example.retrofitdemocleandagger.data.repository.album.datasource.AlbumCacheDataSource
import com.example.retrofitdemocleandagger.data.repository.album.datasourceImpl.AlbumCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideAlbumCacheDataSource(): AlbumCacheDataSource {
        return AlbumCacheDataSourceImpl()
    }
}