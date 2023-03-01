package com.example.retrofitdemocleandagger.presentation.di.core

import com.example.retrofitdemocleandagger.data.api.JSONPlaceHolderService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideJSONPlaceHolderService(retrofit: Retrofit): JSONPlaceHolderService {
        return retrofit.create(JSONPlaceHolderService::class.java)
    }

}