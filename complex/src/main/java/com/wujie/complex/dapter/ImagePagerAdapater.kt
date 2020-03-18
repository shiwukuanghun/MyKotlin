package com.wujie.complex.dapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.wujie.complex.bean.GoodsInfo
import android.view.ViewGroup.LayoutParams
import android.widget.ImageView.ScaleType.FIT_CENTER

class ImagePagerAdapater(private val context: Context, private val goodsList: MutableList<GoodsInfo>) : PagerAdapter() {

    private val views = mutableListOf<ImageView>()

    //初始化函数进行开发者额外的初始操作
    init {
        for (item in goodsList) {
            val view = ImageView(context)
            view.layoutParams = ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            view.setImageResource(item.pic)
            view.scaleType = FIT_CENTER
            views.add(view)
        }
    }

    //判断指定页面是否已加入适配器，注意这里用到了引用相等
    override fun isViewFromObject(arg0: View, arg1: Any): Boolean = (arg0 === arg1)

    //回收页面
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(views[position])
    }

    //实例化每个页面
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(views[position])
        return views[position]
    }

    //获得页面的标题，要跟PagerTabStrip配合使用
    override fun getPageTitle(position: Int): CharSequence = goodsList[position].name

    //获取页面数量，使用了简化函数
    override fun getCount(): Int = goodsList.size
}