package com.wujie.complex

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.wujie.complex.dapter.RecyclerCollapseAdapter
import kotlinx.android.synthetic.main.activity_scroll_flag.*
import org.jetbrains.anko.selector

class ScrollFlagActivity : AppCompatActivity() {

    private val years = arrayOf("鼠年", "牛年", "虎年", "兔年", "龙年", "蛇年", "马年", "羊年", "猴年", "鸡年", "狗年", "猪年")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_flag)

        tl_title.setBackgroundColor(Color.YELLOW)
        setSupportActionBar(tl_title)
        ctl_title.title = "滚动标志"
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.adapter = RecyclerCollapseAdapter(this, years)
    }

    private val descs = listOf("scroll", "scroll|enterAlways", "scroll|exitUntilCollapsed", "scroll|enterAlways|enterAlwaysCollapsed", "scroll|snap")
    private val flags = intArrayOf(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL, AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS, AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED, AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED, AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP)
    private fun initFlagSpinner() {
        sp_flag.visibility = View.GONE
        tv_spinner.visibility = View.VISIBLE
        tv_spinner.text = descs[0]
        tv_spinner.setOnClickListener {
            selector("请选择滚动标志", descs) {_,i ->
                tv_spinner.text = descs[i]
                val params = ctl_title.layoutParams as AppBarLayout.LayoutParams
                params.scrollFlags = flags[i]
            }
        }
    }

}