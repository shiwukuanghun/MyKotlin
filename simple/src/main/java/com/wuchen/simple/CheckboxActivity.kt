package com.wuchen.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_checkbox.*
import org.jetbrains.anko.toast

/**
 * Time：2019/5/22 15:18
 * Author：WuChen
 * Description：
 * **/
class CheckboxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)
        ck_select.isChecked = false
        ck_select.setOnCheckedChangeListener { buttonView, isChecked ->
            tv_select.text = "你${if (isChecked) "勾选" else "取消"}了复选框"
        }
    }

}