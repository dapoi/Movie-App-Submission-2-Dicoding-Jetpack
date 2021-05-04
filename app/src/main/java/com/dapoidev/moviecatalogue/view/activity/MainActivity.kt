package com.dapoidev.moviecatalogue.view.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.dapoidev.moviecatalogue.databinding.ActivityMainBinding
import com.dapoidev.moviecatalogue.view.adapter.SectionPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configViewPager()
    }

    private fun configViewPager() {
        binding.apply {
            val sectionPagerAdapter = SectionPagerAdapter(this@MainActivity, supportFragmentManager)
            viewPager.adapter = sectionPagerAdapter

            tabs.setupWithViewPager(viewPager)
            supportActionBar?.elevation = 0f
        }
    }
}