package com.example.retrofitdemocleandagger.presentation.di.core

import com.example.retrofitdemocleandagger.data.api.JSONPlaceHolderService
import com.example.retrofitdemocleandagger.data.repository.album.datasource.AlbumRemoteDataSource
import com.example.retrofitdemocleandagger.data.repository.album.datasourceImpl.AlbumRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideAlbumRemoteDataSource(jsonPlaceHolderService: JSONPlaceHolderService): AlbumRemoteDataSource {
        return AlbumRemoteDataSourceImpl(
            jsonPlaceHolderService
        )
    }
}