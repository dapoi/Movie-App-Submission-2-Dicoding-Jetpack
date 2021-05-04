package com.dapoidev.moviecatalogue.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dapoidev.moviecatalogue.databinding.FragmentTvBinding
import com.dapoidev.moviecatalogue.view.activity.DetailActivity
import com.dapoidev.moviecatalogue.view.adapter.TVShowsAdapter
import com.dapoidev.moviecatalogue.viewmodel.DetailFilmViewModel.Companion.TV_SHOW
import com.dapoidev.moviecatalogue.viewmodel.FilmViewModel
import com.dapoidev.moviecatalogue.viewmodel.ViewModelFactory
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

class TVShowsFragment : Fragment(), TVShowsAdapter.OnItemClickCallback {

    private lateinit var fragmentTVBinding: FragmentTvBinding
    private lateinit var tvShowsAdapter: TVShowsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTVBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return fragmentTVBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            true.progressBar()

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FilmViewModel::class.java]

            tvShowsAdapter = TVShowsAdapter()

            viewModel.getListTVShows().observe(viewLifecycleOwner, { tvShows ->
                false.progressBar()
                tvShowsAdapter.apply {
                    setTVShow(tvShows)
                    notifyDataSetChanged()
                    setOnItemClickCallback(this@TVShowsFragment)
                }
                setRecyclerView()
            })
        }
    }

    private fun setRecyclerView() {
        fragmentTVBinding.rvTvshows.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = tvShowsAdapter

            OverScrollDecoratorHelper.setUpOverScroll(this, OverScrollDecoratorHelper.ORIENTATION_VERTICAL)
        }
    }

    private fun Boolean.progressBar() {
        fragmentTVBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }

    override fun onItemClicked(id: String) {
        Intent(context, DetailActivity::class.java).also {
            it.putExtra(DetailActivity.EXTRAS_DATA, id)
            it.putExtra(DetailActivity.EXTRAS_CHOOSE, TV_SHOW)
            context?.startActivity(it)
        }
    }
}
