package com.wujie.complex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wujie.complex.util.DateUtil
import kotlinx.android.synthetic.main.activity_broadcast_system.*

class BroadSystemActivity : AppCompatActivity() {

    var desc = "开始侦听分钟广播，请稍等。注意要保持屏幕亮着，才能正常收到广播"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_system)

        tv_system.text = desc
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    //定义一个时间广播的接收器
    private inner class TimeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent!=null) {
                desc = "$desc\n${DateUtil.nowTime}收到一个${intent.action}广播"
                tv_system.text = desc
            }
        }

    }

}