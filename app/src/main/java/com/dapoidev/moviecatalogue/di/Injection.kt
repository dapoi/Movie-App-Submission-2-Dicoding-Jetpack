package com.dapoidev.moviecatalogue.di

import android.content.Context
import com.dapoidev.moviecatalogue.model.data.remote.repository.FilmCatalogueRepository
import com.dapoidev.moviecatalogue.model.data.remote.source.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): FilmCatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return FilmCatalogueRepository.getInstance(remoteDataSource)
    }
}