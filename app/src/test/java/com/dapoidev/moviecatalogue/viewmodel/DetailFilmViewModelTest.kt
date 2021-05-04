package com.dapoidev.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dapoidev.moviecatalogue.model.data.entity.DetailEntity
import com.dapoidev.moviecatalogue.model.data.remote.repository.FilmCatalogueRepository
import com.dapoidev.moviecatalogue.utils.DataDetailDummy
import com.dapoidev.moviecatalogue.viewmodel.DetailFilmViewModel.Companion.MOVIE
import com.dapoidev.moviecatalogue.viewmodel.DetailFilmViewModel.Companion.TV_SHOW
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailFilmViewModelTest {

    private lateinit var viewModel: DetailFilmViewModel

    private val dummyDetailMovie = DataDetailDummy.getDetailMovie()
    private val movieID = dummyDetailMovie.id.toString()

    private val dummyDetailTVShow = DataDetailDummy.getDetailTVShow()
    private val tvShowID = dummyDetailTVShow.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmCatalogueRepository: FilmCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<DetailEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<DetailEntity>

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(filmCatalogueRepository)
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<DetailEntity>()
        movie.value = dummyDetailMovie

        `when`(filmCatalogueRepository.loadDetailMovies(movieID)).thenReturn(movie)
        viewModel.setDetailFilm(movieID, MOVIE)
        val detailMovie = viewModel.getDetailFilm().value
        verify(filmCatalogueRepository).loadDetailMovies(movieID)
        assertNotNull(detailMovie)

        dummyDetailMovie.apply {
            assertEquals(id, detailMovie?.id)
            assertEquals(title, detailMovie?.title)
            assertEquals(date, detailMovie?.date)
            assertEquals(genres, detailMovie?.genres)
            assertEquals(imageDetail, detailMovie?.imageDetail)
            assertEquals(desc, detailMovie?.desc)
        }

        viewModel.getDetailFilm().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyDetailMovie)
    }

    @Test
    fun getTVShow() {
        val tvShow = MutableLiveData<DetailEntity>()
        tvShow.value = dummyDetailTVShow

        `when`(filmCatalogueRepository.loadDetailTVShows(tvShowID)).thenReturn(tvShow)
        viewModel.setDetailFilm(tvShowID, TV_SHOW)
        val detailTVShow = viewModel.getDetailFilm().value
        verify(filmCatalogueRepository).loadDetailTVShows(tvShowID)
        assertNotNull(detailTVShow)

        dummyDetailTVShow.apply {
            assertEquals(id, detailTVShow?.id)
            assertEquals(title, detailTVShow?.title)
            assertEquals(date, detailTVShow?.date)
            assertEquals(genres, detailTVShow?.genres)
            assertEquals(imageDetail, detailTVShow?.imageDetail)
            assertEquals(desc, detailTVShow?.desc)
        }

        viewModel.getDetailFilm().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyDetailTVShow)
    }
}