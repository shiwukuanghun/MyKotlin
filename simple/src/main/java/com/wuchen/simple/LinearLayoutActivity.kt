package com.wuchen.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_linear_layout.*
import org.jetbrains.anko.dip

/**
 * Time：2019/5/22 15:38
 * Author：WuChen
 * Description：
 * **/
class LinearLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)
        //设置ll_margin内部视图的排列方式为水平排列
        ll_margin.orientation = LinearLayout.HORIZONTAL
        //设置ll_margin内部视图的对齐方式为居中对齐
        ll_margin.gravity = Gravity.CENTER
        btn_margin_vertical.setOnClickListener {
            val params = ll_margin.layoutParams as LinearLayout.LayoutParams
            params.setMargins(0, dip(50), 0, dip(50))
            ll_margin.layoutParams = params
        }

        btn_margin_horizontal.setOnClickListener {
            val params = ll_margin.layoutParams as LinearLayout.LayoutParams
            params.setMargins(dip(50),0,dip(50),0)
            ll_margin.layoutParams = params
        }
        btn_padding_vertical.setOnClickListener {
            ll_margin.setPadding(0, dip(50),0,dip(50))
        }
        btn_padding_horizontal.setOnClickListener {
            ll_margin.setPadding(dip(50),0,dip(50),0)
        }
    }
}