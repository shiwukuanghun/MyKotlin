package com.wuchen.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_alert_dialog.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert

/**
 * Time：2019/5/24 10:32
 * Author：WuChen
 * Description：
 * **/
class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        btn_alert.setOnClickListener {
            alert("你真的要卸载吗", "尊敬的用户") {
                positiveButton("残忍卸载"){tv_alert.text = "虽然依依不舍，但是只能离开了"}
                negativeButton("让我再想想"){tv_alert.text = "让我再陪你三百六十五个日夜"}
            }.show()
        }
    }
}