package com.dapoidev.moviecatalogue.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dapoidev.moviecatalogue.R
import com.dapoidev.moviecatalogue.databinding.ActivityDetailBinding
import com.dapoidev.moviecatalogue.model.data.entity.DetailEntity
import com.dapoidev.moviecatalogue.viewmodel.DetailFilmViewModel
import com.dapoidev.moviecatalogue.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRAS_DATA = "extras_data"
        const val EXTRAS_CHOOSE = "choose"
    }

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailFilmViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {

            val filmID = extras.getString(EXTRAS_DATA)
            val filmChoose = extras.getString(EXTRAS_CHOOSE)

            if (filmID != null && filmChoose != null) {
                true.progressBar()

                viewModel.setDetailFilm(filmID, filmChoose)
                viewModel.getDetailFilm().observe(this, { detail ->
                    false.progressBar()
                    generateDataDetail(detail)
                })
            }
        }
    }

    private fun generateDataDetail(detail: DetailEntity) {

        if (supportActionBar != null) {
            title = detail.title + " Detail's"
        }

        val genre = detail.genres.toString()
            .replace("[", "")
            .replace("]", "")

        detailBinding.apply {
            tvDetailTitle.text = detail.title
            tvDetailDate.text = detail.date
            tvDetailGenre.text = genre
            tvDetailDesc.text = detail.desc

            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w500" + detail.imageDetail)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imgDetail)
        }
    }

    private fun Boolean.progressBar() {
        detailBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }
}