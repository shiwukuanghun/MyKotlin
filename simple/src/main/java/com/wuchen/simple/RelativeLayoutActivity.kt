package com.wuchen.simple

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_relative_layout.*
import org.jetbrains.anko.*

/**
 * Time：2019/5/22 15:52
 * Author：WuChen
 * Description：
 * **/
class RelativeLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        btn_add_left.setOnClickListener { v ->
            val rl_params = RelativeLayout.LayoutParams(dip(50), dip(50))
            rl_params.leftOf(v)  //位于v的左边
            rl_params.sameTop(v)    //与v的顶部对齐
            addNewView(rl_params)
        }
        btn_add_above.setOnClickListener { v->
            val rl_params = RelativeLayout.LayoutParams(dip(50),dip(50))
            rl_params.above(v.id)   //位于v的上方
            rl_params.sameLeft(v.id)    //yuv的左侧对齐
            addNewView(rl_params)
        }
        btn_add_right.setOnClickListener {v->
            var rl_params = RelativeLayout.LayoutParams(dip(50),dip(50))
            rl_params.rightOf(v)    //位于v的右侧
            rl_params.sameBottom(v) //与v的底部对齐
            addNewView(rl_params)
        }
        btn_add_below.setOnClickListener {v->
            val rl_params = RelativeLayout.LayoutParams(dip(50), dip(50))
            rl_params.below(v)  //位于v的下方
            rl_params.sameRight(v)  //与v的右侧对齐
            addNewView(rl_params)
        }
        btn_add_parent_left.setOnClickListener { v->
            val rl_params = RelativeLayout.LayoutParams(dip(50),dip(50))
            rl_params.alignParentLeft() //与父控件的左侧对齐
            rl_params.centerVertically()    //垂直居中
            addNewView(rl_params)
        }
        btn_add_parent_top.setOnClickListener {
            val rl_params = RelativeLayout.LayoutParams(dip(50),dip(50))
            rl_params.alignParentTop()  //位于父控件的顶部
            rl_params.centerHorizontally()  //水平居中
            addNewView(rl_params)
        }
        btn_add_parent_right.setOnClickListener {
            val rl_params = RelativeLayout.LayoutParams(dip(50), dip(50))
            rl_params.alignParentRight()    //位于父控件的右侧
            addNewView(rl_params)
        }
        btn_add_parent_bottom.setOnClickListener {
            val rl_param = RelativeLayout.LayoutParams(dip(50), dip(50))
            rl_param.alignParentBottom()    //位于父控件的底部
            addNewView(rl_param)
        }
    }

    private fun addNewView(rl_params: RelativeLayout.LayoutParams) {
        var v = View(this)
        v.setBackgroundColor(Color.GREEN)
        v.layoutParams = rl_params
        v.setOnLongClickListener { vv -> rl_content.removeView(vv); true}
        rl_content.addView(v)
    }

}