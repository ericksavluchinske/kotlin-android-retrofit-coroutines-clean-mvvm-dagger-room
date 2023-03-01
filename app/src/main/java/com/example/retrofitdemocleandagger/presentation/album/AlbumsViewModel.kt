package com.example.retrofitdemocleandagger.presentation.album

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.retrofitdemocleandagger.domain.usecase.GetAlbumsUseCase
import com.example.retrofitdemocleandagger.domain.usecase.UpdateAlbumsUseCase

class AlbumsViewModel(
    private val getAlbumsUseCase: GetAlbumsUseCase,
    private val updateAlbumsUseCase: UpdateAlbumsUseCase
): ViewModel() {

    fun getAlbums() = liveData {
        val albumList = getAlbumsUseCase.execute()
        emit(albumList)
    }

    fun updateAlbums() = liveData {
        val albumList = updateAlbumsUseCase.execute()
        emit(albumList)
    }
}