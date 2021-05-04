package com.dapoidev.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dapoidev.moviecatalogue.model.data.entity.MovieEntity
import com.dapoidev.moviecatalogue.model.data.entity.TVShowEntity
import com.dapoidev.moviecatalogue.model.data.remote.repository.FilmCatalogueRepository

class FilmViewModel(private val filmCatalogueRepository: FilmCatalogueRepository) : ViewModel() {

    fun getListMovies(): LiveData<List<MovieEntity>> = filmCatalogueRepository.loadMovies()

    fun getListTVShows(): LiveData<List<TVShowEntity>> = filmCatalogueRepository.loadTVShows()
}