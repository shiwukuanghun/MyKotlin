package com.wujie.complex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import com.wujie.complex.bean.GoodsInfo
import com.wujie.complex.dapter.BroadcastPagerAdapter
import com.wujie.complex.fragment.BroadcastFragment
import kotlinx.android.synthetic.main.activity_broadcast_temp.*

class BroadTempActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_temp)

        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        var adapter = BroadcastPagerAdapter(supportFragmentManager, GoodsInfo.defaultList)
        vp_content.adapter = adapter
        vp_content.currentItem = 0
    }

    override fun onStart() {
        super.onStart()
        bgChangeReceiver = BgChangeReceiver()
        //声明一个过滤器，明确只接收名称为BroadcastFragment.EVENT的广播
        val filter = IntentFilter(BroadcastFragment.EVENT)
        //在活动启动时注册广播接收器
        registerReceiver(bgChangeReceiver, filter)
    }

    override fun onStop() {
        //在活动停止时注销广播接收器
        unregisterReceiver(bgChangeReceiver)
        super.onStop()
    }

    private var bgChangeReceiver : BgChangeReceiver? = null
    //定义一个背景色变更的广播接收器
    private inner class BgChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent!=null) {
                //从广播消息中获取新颜色，并将页面背景色修改成新颜色
                var color = intent.getIntExtra("color", Color.WHITE)
                ll_brd_temp.setBackgroundColor(color)
            }
        }

    }

}