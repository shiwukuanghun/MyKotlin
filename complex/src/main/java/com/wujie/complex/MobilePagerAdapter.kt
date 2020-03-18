package com.wujie.complex

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.wujie.complex.bean.GoodsInfo
import com.wujie.complex.fragment.DynamicFragment

class MobilePagerAdapter(fm : FragmentManager, private val goodsList : MutableList<GoodsInfo>) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {
        val item  = goodsList[p0]
        return DynamicFragment.newInstance(p0, item.pic, item.desc, item.price)
    }

    //获取页面的数量
    override fun getCount(): Int = goodsList.size

    override fun getPageTitle(position: Int): CharSequence? {
        return goodsList[position].name
    }
}