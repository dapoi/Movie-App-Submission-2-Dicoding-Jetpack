package com.dapoidev.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dapoidev.moviecatalogue.model.data.entity.MovieEntity
import com.dapoidev.moviecatalogue.model.data.entity.TVShowEntity
import com.dapoidev.moviecatalogue.model.data.remote.repository.FilmCatalogueRepository
import com.dapoidev.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FilmViewModelTest {

    private lateinit var viewModel: FilmViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmCatalogueRepository: FilmCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<List<MovieEntity>>

    @Mock
    private lateinit var tvObserver: Observer<List<TVShowEntity>>

    @Before
    fun setUp() {
        viewModel = FilmViewModel(filmCatalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovie = DataDummy.getMovies()
        val listMovie = MutableLiveData<List<MovieEntity>>()
        listMovie.value = dummyMovie

        `when`(filmCatalogueRepository.loadMovies()).thenReturn(listMovie)
        val movieEntity = viewModel.getListMovies().value
        verify(filmCatalogueRepository).loadMovies()
        assertNotNull(movieEntity)
        assertEquals(5, movieEntity?.size)

        viewModel.getListMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTVShows() {
        val dummyTVShow = DataDummy.getTVShows()
        val listTVShow = MutableLiveData<List<TVShowEntity>>()
        listTVShow.value = dummyTVShow

        `when`(filmCatalogueRepository.loadTVShows()).thenReturn(listTVShow)
        val tvShowEntity = viewModel.getListTVShows().value
        verify(filmCatalogueRepository).loadTVShows()
        assertNotNull(tvShowEntity)
        assertEquals(5, tvShowEntity?.size)

        viewModel.getListTVShows().observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyTVShow)
    }

}