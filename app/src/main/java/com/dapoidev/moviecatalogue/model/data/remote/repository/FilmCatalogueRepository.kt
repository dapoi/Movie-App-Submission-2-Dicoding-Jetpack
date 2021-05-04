package com.dapoidev.moviecatalogue.model.data.remote.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dapoidev.moviecatalogue.model.data.entity.DetailEntity
import com.dapoidev.moviecatalogue.model.data.entity.MovieEntity
import com.dapoidev.moviecatalogue.model.data.entity.TVShowEntity
import com.dapoidev.moviecatalogue.model.data.remote.response.movie.MovieRemote
import com.dapoidev.moviecatalogue.model.data.remote.response.movie.MoviesDetailResponse
import com.dapoidev.moviecatalogue.model.data.remote.response.tvshow.TVShowRemote
import com.dapoidev.moviecatalogue.model.data.remote.response.tvshow.TVShowsDetailResponse
import com.dapoidev.moviecatalogue.model.data.remote.source.FilmDataSource
import com.dapoidev.moviecatalogue.model.data.remote.source.RemoteDataSource

class FilmCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    FilmDataSource {

    companion object {
        @Volatile
        private var instance: FilmCatalogueRepository? = null

        fun getInstance(remote: RemoteDataSource): FilmCatalogueRepository =
            instance ?: synchronized(this) {
                FilmCatalogueRepository(remote).apply { instance = this }
            }
    }

    override fun loadMovies(): LiveData<List<MovieEntity>> {
        val getMovie = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getListMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponse: List<MovieRemote>?) {
                val listMovie = ArrayList<MovieEntity>()
                if (moviesResponse != null) {
                    for (movies in moviesResponse) {
                        movies.apply {
                            val movie = MovieEntity(id, title, date, image, desc)
                            listMovie.add(movie)
                        }
                    }
                    getMovie.postValue(listMovie)
                }
            }
        })
        return getMovie
    }

    override fun loadDetailMovies(movieID: String): LiveData<DetailEntity> {
        val getDetailMovie = MutableLiveData<DetailEntity>()

        remoteDataSource.getDetailMovies(object : RemoteDataSource.LoadDetailMoviesCallback {
            override fun onAllDetailMoviesReceived(moviesDetail: MoviesDetailResponse?) {
                lateinit var detailMovie: DetailEntity
                moviesDetail?.apply {

                    val listGenre = ArrayList<String>()
                    for (genre in genres) {
                        listGenre.add(genre.name)
                    }

                    detailMovie = DetailEntity(
                        id = id,
                        title = title,
                        date = date,
                        genres = listGenre,
                        imageDetail = imageDetail,
                        desc = desc
                    )
                    getDetailMovie.postValue(detailMovie)
                }
            }
        }, movieID)
        return getDetailMovie
    }

    override fun loadTVShows(): LiveData<List<TVShowEntity>> {
        val getTVShow = MutableLiveData<List<TVShowEntity>>()

        remoteDataSource.getListTVShows(object : RemoteDataSource.LoadTVShowCallback {
            override fun onAllTVShowsReceived(tvResponse: List<TVShowRemote>?) {
                val listTVShow = ArrayList<TVShowEntity>()
                if (tvResponse != null) {
                    for (tvShows in tvResponse) {
                        tvShows.apply {
                            val tvShow = TVShowEntity(id, title, date, desc, image)
                            listTVShow.add(tvShow)
                        }
                    }
                    getTVShow.postValue(listTVShow)
                }
            }
        })
        return getTVShow
    }

    override fun loadDetailTVShows(tvShowID: String): LiveData<DetailEntity> {
        val getDetailTVShow = MutableLiveData<DetailEntity>()

        remoteDataSource.getDetailTVShows(object : RemoteDataSource.LoadDetailTVShowsCallback {
            override fun onAllDetailTVShowsReceived(tvShowsDetail: TVShowsDetailResponse?) {
                lateinit var detailTVShow: DetailEntity
                tvShowsDetail?.apply {

                    val listGenre = ArrayList<String>()
                    for (genre in genres) {
                        listGenre.add(genre.name)
                    }

                    detailTVShow = DetailEntity(
                        id = id,
                        title = title,
                        date = date,
                        genres = listGenre,
                        imageDetail = imageDetail,
                        desc = desc
                    )
                    getDetailTVShow.postValue(detailTVShow)
                }
            }
        }, tvShowID)
        return getDetailTVShow
    }
}