package com.example.retrofitdemocleandagger.presentation.di

import com.example.retrofitdemocleandagger.presentation.di.album.AlbumSubComponent

interface Injector {
    fun createAlbumSubComponent(): AlbumSubComponent
}