package com.wuchen.simple

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wuchen.simple.bean.MessageInfo
import com.wuchen.simple.util.DateUtil
import kotlinx.android.synthetic.main.activity_act_request.*
import org.jetbrains.anko.startActivityForResult

/**
 * Time：2019/5/23 14:24
 * Author：WuChen
 * Description：
 * **/
class ActRequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_request)

        btn_act_request.setOnClickListener {
            val info = MessageInfo(et_request.text.toString(), DateUtil.nowDateTime)
            startActivityForResult<ActResponseActivity>(0,"message" to info)
        }
    }

    //从下个页面返回到本页面时回调onActivityResult方法
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data!=null) {
            //获得下一个页面的应答参数
            val response = data.extras.getParcelable<MessageInfo>("message")
            tv_request.text = "收到返回消息：\n应答时间为${response.send_time}\n应答内容为${response.content}"
        }
    }
}