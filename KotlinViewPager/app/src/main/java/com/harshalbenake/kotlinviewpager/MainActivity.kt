package com.harshalbenake.kotlinviewpager

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.MenuItem
import com.harshalbenake.kotlinviewpager.adapter.CustomPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLayout()
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> false
    }
    /**
     * init Layout
     */
    private fun initLayout() {
        val fragmentAdapter = CustomPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter
        tablayout_main.setupWithViewPager(viewpager_main)
    }
}