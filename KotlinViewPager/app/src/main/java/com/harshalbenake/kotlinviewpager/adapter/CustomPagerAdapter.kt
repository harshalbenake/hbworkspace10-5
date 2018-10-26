package com.harshalbenake.kotlinviewpager.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.caressa.libs.leaderboard.ui.fragments.FirstFragment
import com.caressa.libs.leaderboard.ui.fragments.SecondFragment

class CustomPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 ->FirstFragment()
            else -> {
                return SecondFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "First"
            else -> {
                return "Second"
            }
        }
    }
}