package com.wuchen.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wuchen.simple.bean.MessageInfo
import com.wuchen.simple.util.DateUtil
import kotlinx.android.synthetic.main.activity_parcelable_first.*
import org.jetbrains.anko.startActivity

/**
 * Time：2019/5/23 14:05
 * Author：WuChen
 * Description：
 * **/
class ParcelableFirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable_first)
        btn_act_request.setOnClickListener {
            val request = MessageInfo(et_request.text.toString(), DateUtil.nowDateTime)
            startActivity<ParcelableSecondActivity>("message" to request)
        }
    }
}