package com.wuchen.mykotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_function.*

/**
 * Time：2019/5/14 10:52
 * Author：WuChen
 * Description：
 * **/
class FunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function)

        btn_input_empty.setOnClickListener { getDinnerEmpty() }
        btn_input_param.setOnClickListener { getDinnerInput(2, 1111.1111, "水沝淼", 10000f) }
        btn_input_null.setOnClickListener { getDinnerCanNull(2, 1111.1111, null, 10000f) }
        btn_output_empty.setOnClickListener { getDinnerUnit() }
        btn_output_param.setOnClickListener { tv_result.text = getDinnerOutput() }
        btn_full_param.setOnClickListener { tv_result.text = getDinnerFull(2, 1111.1111, "水沝淼", 10000f) }
    }

    //没有输入参数，也没有输出参数
    fun getDinnerEmpty() {
        tv_process.text = "只有空盘子哦"
        tv_result.text = ""
    }

    //只有输入参数
    fun getDinnerInput(egg:Int, leak:Double, water:String, shell:Float) {
        tv_process.text = "食材包括：两个鸡蛋、一把韭菜、几瓢清水"
        tv_result.text = ""
    }

    //输入参数存在空值
    fun getDinnerCanNull(egg:Int, leak:Double, water:String?, shell:Float) {
        tv_process.text = if (water!=null) "食材包括：两个鸡蛋、一把韭菜、几瓢清水" else "没有水没法做汤啦"
        tv_result.text = ""
    }

    //Unit类型表示没有返回参数，可以直接省略Unit声明
    fun getDinnerUnit():Unit {
        tv_process.text = "只有空盘子哟"
        tv_result.text = ""
    }

    //只有输出参数
    fun getDinnerOutput():String {
        tv_process.text = "只有空盘子哟"
        var dinner:String = "巧妇难为无米之炊，汝速去买菜"
        return dinner
    }

    fun getDinnerFull(egg:Int, leek:Double, water:String?, shell:Float) :String {
        tv_process.text = if (water!=null) "食材包括：两个鸡蛋、一把韭菜、几瓢清水" else "没有水没法做汤啦"
        var dinner:String = "两个黄鹂鸣翠柳，\n一行白鹭上青天。\n窗含西岭千秋雪，\n门泊东吴万里船。"
        return dinner
    }

}