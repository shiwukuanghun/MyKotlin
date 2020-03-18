package com.wujie.complex

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.wujie.complex.dapter.GoodsPagerAdapter
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayoutActivity : AppCompatActivity()/*, TabLayout.OnTabSelectedListener*/ {

    private val titles = mutableListOf("商品", "详情")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        //使用自定义的工具栏替换系统默认的导航栏
        setSupportActionBar(tl_head)
        tl_head.setNavigationOnClickListener { finish() }
        initTabLayout()
        initTabViewPager()
    }

    //初始化页面主体的翻页视图
    private fun initTabViewPager() {
        vp_content.adapter = GoodsPagerAdapter(supportFragmentManager, titles)
        //利用object关键字表示声明一个匿名实例
        vp_content.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                //翻页操作停止后，同步切换到对应的文本标签
                tab_title.getTabAt(position)!!.select()
            }
        })
    }


    //初始化头部的文本标签
    private fun initTabLayout() {
        tab_title.addTab(tab_title.newTab().setText(titles[0]))
        tab_title.addTab(tab_title.newTab().setText(titles[1]))
//        tab_title.addOnTabSelectedListener(this)
        tab_title.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                vp_content.currentItem = p0!!.position
            }

        })
    }

//    override fun onTabReselected(tab: TabLayout.Tab) {}
//
//    //文本标签选中后，同步切换到对应的翻页页面
//    override fun onTabSelected(tab: TabLayout.Tab) {
//        vp_content.currentItem = tab.position
//    }
//
//    override fun onTabUnselected(tab: TabLayout.Tab) {}

}