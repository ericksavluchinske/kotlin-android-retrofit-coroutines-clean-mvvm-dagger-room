package com.example.retrofitdemocleandagger.presentation.di.core

import com.example.retrofitdemocleandagger.domain.repository.AlbumRepository
import com.example.retrofitdemocleandagger.domain.usecase.GetAlbumsUseCase
import com.example.retrofitdemocleandagger.domain.usecase.UpdateAlbumsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetAlbumsUseCase(albumRepository: AlbumRepository): GetAlbumsUseCase {
        return GetAlbumsUseCase(albumRepository)
    }
    @Provides
    fun provideUpdateAlbumsUseCase(albumRepository: AlbumRepository): UpdateAlbumsUseCase {
        return UpdateAlbumsUseCase(albumRepository)
    }
}