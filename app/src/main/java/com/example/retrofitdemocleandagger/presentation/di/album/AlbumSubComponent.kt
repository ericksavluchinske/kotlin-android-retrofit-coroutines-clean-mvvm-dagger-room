package com.example.retrofitdemocleandagger.presentation.di.album

import com.example.retrofitdemocleandagger.AlbumsActivity
import dagger.Subcomponent

@AlbumScope
@Subcomponent(modules = [AlbumModule::class])
interface AlbumSubComponent {
    fun inject(albumsActivity: AlbumsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): AlbumSubComponent
    }
}