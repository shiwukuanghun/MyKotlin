package com.wuchen.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_button_click.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

/**
 * Time：2019/5/22 14:54
 * Author：WuChen
 * Description：
 * **/
class ButtonClickActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_click)

        //点击事件第一种：匿名函数方式
        btn_click_anonymos.setOnClickListener { v->
            //Kotlin对变量进行类型转换的关键字是as
            toast("你点击了控件${(v as Button).text}")
        }
        btn_click_anonymos.setOnLongClickListener { v->
            //Kotlin对变量进行类型转换的关键字是as
            longToast("你长按了控件${(v as Button).text}")
            true  //返回false的话长按松开后还会走短按的点击事件
        }

        //点击事件第二种：内部类方式
        btn_click_inner.setOnClickListener(MyClickListener())
        btn_click_inner.setOnLongClickListener(MyLongClickListener())
        //点击事件第三种：Activity实现接口
        btn_click_interface.setOnClickListener(this)
        btn_click_interface.setOnLongClickListener(this)
    }

    private inner class MyClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            toast("你点击了控件${(v as Button).text}")
        }
    }

    private inner class MyLongClickListener : View.OnLongClickListener {
        override fun onLongClick(v: View?): Boolean {
            toast("你长按了控件${(v as Button).text}")
            return true
        }
    }

    override fun onLongClick(v: View?): Boolean {
        toast("你点击了控件${(v as Button).text}")
        return true
    }

    override fun onClick(v: View?) {
        toast("你点击了控件${(v as Button).text}")
    }

    fun onButtonClick(v:View) {
        toast("你点击了控件${(v as Button).text}")
    }

}