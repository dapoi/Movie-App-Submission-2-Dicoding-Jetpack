package com.dapoidev.moviecatalogue.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dapoidev.moviecatalogue.databinding.FragmentMoviesBinding
import com.dapoidev.moviecatalogue.view.activity.DetailActivity
import com.dapoidev.moviecatalogue.view.adapter.MoviesAdapter
import com.dapoidev.moviecatalogue.viewmodel.DetailFilmViewModel.Companion.MOVIE
import com.dapoidev.moviecatalogue.viewmodel.FilmViewModel
import com.dapoidev.moviecatalogue.viewmodel.ViewModelFactory
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

class MoviesFragment : Fragment(), MoviesAdapter.OnItemClickCallback {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            true.progressBar()

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FilmViewModel::class.java]
            moviesAdapter = MoviesAdapter()

            viewModel.getListMovies().observe(viewLifecycleOwner, { movies ->
                false.progressBar()
                moviesAdapter.apply {
                    setMovies(movies)
                    notifyDataSetChanged()
                    setOnItemClickCallback(this@MoviesFragment)
                }
                setRecyclerView()
            })
        }
    }

    private fun setRecyclerView() {
        fragmentMoviesBinding.rvMovies.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = moviesAdapter

            OverScrollDecoratorHelper.setUpOverScroll(this, OverScrollDecoratorHelper.ORIENTATION_VERTICAL)
        }
    }

    private fun Boolean.progressBar() {
        fragmentMoviesBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }

    override fun onItemClicked(id: String) {
        Intent(context, DetailActivity::class.java).also {
            it.putExtra(DetailActivity.EXTRAS_DATA, id)
            it.putExtra(DetailActivity.EXTRAS_CHOOSE, MOVIE)
            context?.startActivity(it)
        }
    }
}
