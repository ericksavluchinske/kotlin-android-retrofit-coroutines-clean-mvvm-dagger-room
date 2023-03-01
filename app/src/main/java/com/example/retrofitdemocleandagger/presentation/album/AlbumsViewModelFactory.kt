package com.example.retrofitdemocleandagger.presentation.album

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemocleandagger.domain.usecase.GetAlbumsUseCase
import com.example.retrofitdemocleandagger.domain.usecase.UpdateAlbumsUseCase

class AlbumsViewModelFactory(
    private val getAlbumsUseCase: GetAlbumsUseCase,
    private val updateAlbumsUseCase: UpdateAlbumsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlbumsViewModel(getAlbumsUseCase,updateAlbumsUseCase) as T
    }
}