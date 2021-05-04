package com.dapoidev.moviecatalogue.model.data.remote.source

import androidx.lifecycle.LiveData
import com.dapoidev.moviecatalogue.model.data.entity.DetailEntity
import com.dapoidev.moviecatalogue.model.data.entity.MovieEntity
import com.dapoidev.moviecatalogue.model.data.entity.TVShowEntity

interface FilmDataSource {
    fun loadMovies(): LiveData<List<MovieEntity>>

    fun loadDetailMovies(movieID: String): LiveData<DetailEntity>

    fun loadTVShows(): LiveData<List<TVShowEntity>>

    fun loadDetailTVShows(tvShowID: String): LiveData<DetailEntity>
}