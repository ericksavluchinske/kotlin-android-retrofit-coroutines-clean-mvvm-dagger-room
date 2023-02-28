package com.example.retrofitdemocleandagger.domain.usecase

import com.example.retrofitdemocleandagger.data.model.album.Album
import com.example.retrofitdemocleandagger.domain.repository.AlbumRepository

class GetAlbumsUseCase(private val albumRepository: AlbumRepository) {
    suspend fun execute():List<Album>? = albumRepository.getAlbums()
}