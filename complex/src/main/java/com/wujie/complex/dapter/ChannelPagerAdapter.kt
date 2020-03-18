package com.wujie.complex.dapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.wujie.complex.fragment.AppliancesFragment
import com.wujie.complex.fragment.ClothesFragment

class ChannelPagerAdapter(fm: FragmentManager, private val titles: MutableList<String>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> ClothesFragment()
            1 -> AppliancesFragment()
            else -> ClothesFragment()
        }


    override fun getCount(): Int = titles.size

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    companion object {
        const val EVENT = "com.example.complex.adapter.ChannelPagerAdapter"
    }

}