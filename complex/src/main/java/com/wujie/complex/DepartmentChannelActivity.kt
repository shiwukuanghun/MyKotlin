package com.wujie.complex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wujie.complex.dapter.ChannelPagerAdapter
import kotlinx.android.synthetic.main.activity_department_channel.*

class DepartmentChannelActivity : AppCompatActivity() {

    private val mTitles = mutableListOf("服装", "电器")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department_channel)

        setSupportActionBar(tl_head)
        var pagerAdapter = ChannelPagerAdapter(supportFragmentManager, mTitles)
        vp_content.adapter = pagerAdapter
        tab_title.setupWithViewPager(vp_content)
    }

    override fun onStart() {
        super.onStart()
        bgChangeReceiver = BgChangeReceiver()
        val filter =IntentFilter(ChannelPagerAdapter.EVENT)
        registerReceiver(bgChangeReceiver, filter)
    }

    override fun onStop() {
        unregisterReceiver(bgChangeReceiver)
        super.onStop()
    }

    private var bgChangeReceiver : BgChangeReceiver? = null
    private inner class BgChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                val color = intent.getIntExtra("color", Color.WHITE)
                tl_head.setBackgroundColor(color)
            }
        }

    }

}