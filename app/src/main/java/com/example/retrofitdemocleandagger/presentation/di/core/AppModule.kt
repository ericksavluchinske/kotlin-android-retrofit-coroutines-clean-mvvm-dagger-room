package com.example.retrofitdemocleandagger.presentation.di.core

import android.content.Context
import com.example.retrofitdemocleandagger.presentation.di.album.AlbumSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [AlbumSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}