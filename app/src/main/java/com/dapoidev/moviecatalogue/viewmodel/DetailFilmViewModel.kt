package com.dapoidev.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dapoidev.moviecatalogue.model.data.entity.DetailEntity
import com.dapoidev.moviecatalogue.model.data.remote.repository.FilmCatalogueRepository

class DetailFilmViewModel(private val filmCatalogueRepository: FilmCatalogueRepository) : ViewModel() {

   private lateinit var dataDetailFilm: LiveData<DetailEntity>

    companion object {
        const val MOVIE = "detail_movie"
        const val TV_SHOW = "detail_tv"
    }

    fun setDetailFilm(id: String, choose: String) {
        when(choose) {
            MOVIE -> {
                dataDetailFilm = filmCatalogueRepository.loadDetailMovies(id)
            }
            TV_SHOW -> {
                dataDetailFilm = filmCatalogueRepository.loadDetailTVShows(id)
            }
        }
    }

    fun getDetailFilm() = dataDetailFilm
}