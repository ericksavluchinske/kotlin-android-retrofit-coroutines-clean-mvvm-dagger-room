package com.example.retrofitdemocleandagger.presentation.di.core

import com.example.retrofitdemocleandagger.presentation.di.album.AlbumSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun albumSubComponent(): AlbumSubComponent.Factory

}