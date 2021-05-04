package com.dapoidev.moviecatalogue.model.data.remote.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dapoidev.moviecatalogue.model.data.remote.source.RemoteDataSource
import com.dapoidev.moviecatalogue.utils.DataDetailDummy
import com.dapoidev.moviecatalogue.utils.DataDummy
import com.dapoidev.moviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class FilmCatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val filmCatalogueRepository = FakeFilmCatalogueRepository(remote)

    private val responseMovie = DataDummy.getRemoteMovies()
    private val responseTVShow = DataDummy.getRemoteTVShows()

    private val idMovie = responseMovie[0].id.toString()
    private val idTVShow = responseTVShow[0].id.toString()

    private val detailMovie = DataDetailDummy.getRemoteDetailMovie()
    private val detailTVShow = DataDetailDummy.getRemoteDetailTVShow()

    @Test
    fun getListMovies() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(responseMovie)
            null
        }.`when`(remote).getListMovies(any())

        val movieEntity = LiveDataTestUtil.getValue(filmCatalogueRepository.loadMovies())
        verify(remote).getListMovies(any())
        assertNotNull(movieEntity)
        assertEquals(responseMovie.size.toLong(), movieEntity.size.toLong())
    }

    @Test
    fun getDetailMovies() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailMoviesCallback)
                .onAllDetailMoviesReceived(detailMovie)
            null
        }.`when`(remote).getDetailMovies(any(), eq(idMovie))

        val movieDetailEntity =
            LiveDataTestUtil.getValue(filmCatalogueRepository.loadDetailMovies(idMovie))
        verify(remote).getDetailMovies(any(), eq(idMovie))
        assertNotNull(movieDetailEntity)
        assertEquals(detailMovie.id, movieDetailEntity.id)
    }

    @Test
    fun getListTVShows() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTVShowCallback)
                .onAllTVShowsReceived(responseTVShow)
            null
        }.`when`(remote).getListTVShows(any())

        val tvShowEntity = LiveDataTestUtil.getValue(filmCatalogueRepository.loadTVShows())
        verify(remote).getListTVShows(any())
        assertNotNull(tvShowEntity)
        assertEquals(responseTVShow.size.toLong(), tvShowEntity.size.toLong())
    }

    @Test
    fun getDetailTVShows() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailTVShowsCallback)
                .onAllDetailTVShowsReceived(detailTVShow)
            null
        }.`when`(remote).getDetailTVShows(any(), eq(idTVShow))

        val tvShowDetailEntity =
            LiveDataTestUtil.getValue(filmCatalogueRepository.loadDetailTVShows(idTVShow))
        verify(remote).getDetailTVShows(any(), eq(idTVShow))
        assertNotNull(tvShowDetailEntity)
        assertEquals(detailTVShow.id, tvShowDetailEntity.id)
    }
}