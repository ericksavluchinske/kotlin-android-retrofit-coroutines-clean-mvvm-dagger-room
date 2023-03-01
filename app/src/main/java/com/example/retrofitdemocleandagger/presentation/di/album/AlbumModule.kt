package com.example.retrofitdemocleandagger.presentation.di.album

import com.example.retrofitdemocleandagger.domain.usecase.GetAlbumsUseCase
import com.example.retrofitdemocleandagger.domain.usecase.UpdateAlbumsUseCase
import com.example.retrofitdemocleandagger.presentation.album.AlbumsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AlbumModule {
    @Provides
    fun provideAlbumsViewModelFactory(
        getAlbumsUseCase: GetAlbumsUseCase,
        updateAlbumsUsecase: UpdateAlbumsUseCase
    ): AlbumsViewModelFactory {
        return AlbumsViewModelFactory(
            getAlbumsUseCase,
            updateAlbumsUsecase
        )
    }
}