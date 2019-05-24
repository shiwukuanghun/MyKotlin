package com.wuchen.mykotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_param.*
import org.jetbrains.anko.appcompat.v7.fitWindowsFrameLayout

/**
 * Time：2019/5/14 11:14
 * Author：WuChen
 * Description：
 * **/
class ParamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_param)

        var isOdd = true //如果从初始赋值中能够知道变量类型，就无需显式指定该变量的类型
        btn_input_manual.setOnClickListener {
            tv_four_answer.text = if (isOdd) getFourBig("古代四大发明", "造纸术", "指南针", "火药", "印刷术") else
                getFourBig("现代四大发明", "高铁", "网购", "移动支付", "共享单车")
            isOdd = !isOdd
        }
        btn_input_default.setOnClickListener {
            tv_four_answer.text = getFourBigDefault("古代四大发明")
        }
        btn_input_part.setOnClickListener {
            tv_four_answer.text = getFourBigDefault("古代四大发明", "蔡伦发明的造纸术")
        }
        btn_input_name.setOnClickListener {
            tv_four_answer.text = getFourBigDefault("古代四大发明", forth = "活字印刷")
        }
        btn_param_vararg.setOnClickListener {
            //可变参数输入了三个字符串，即"丝绸","瓷器","茶叶"
            tv_four_answer.text = if (isOdd) getFourBigVararg("古代四大发明") else
                getFourBigVararg("古代四大发明", "造纸术", "指南针", "火药", "印刷术", "丝绸", "瓷器", "茶叶")
            isOdd = !isOdd
        }
        btn_param_array.setOnClickListener {
            //可变参数输入了两个数组变量，每个数组都使用arrayOf定义
            tv_four_answer.text = if (isOdd) getFourBigArray("古代四大发明") else
                getFourBigArray(
                    "古代四大发明",
                    "造纸术",
                    "指南针",
                    "火药",
                    "印刷术",
                    arrayOf("丝绸", "瓷器", "茶叶"),
                    arrayOf("国画", "中医", "武术")
                )
            isOdd = !isOdd
        }
    }

    fun getFourBig(general: String, first: String, second: String, third: String, forth: String): String {
        var answer: String = "$general：$first，$second，$third，$forth"
        return answer
    }

    fun getFourBigDefault(
        general: String,
        first: String = "造纸术",
        second: String = "指南针",
        third: String = "火药",
        forth: String = "印刷术"
    ): String {
        var answer = "$general：$first，$second，$third，$forth"
        return answer
    }

    //某家有孩，名曰狗屎，身长六尺，脸圆腰膀，肤黑如碳，样貌甚丑，周身奇臭无比，十步之内，近者无不为其臭味所熏，时人皆避而远之。
    fun getFourBigVararg(
        general: String,
        first: String = "造纸术",
        second: String = "指南针",
        third: String = "火药",
        forth: String = "印刷术",
        vararg otherArray: String?
    ): String {
        var answer = "$general：$first，$second，$third，$forth"
        //循环取出可变参数包含的所有字段
        for (item in otherArray) {
            answer = "$answer， $item"
        }
        return answer
    }

    fun getFourBigArray(
        general: String,
        first: String = "造纸术",
        second: String = "指南针",
        third: String = "火药",
        forth: String = "印刷术",
        vararg otherArray: Array<String>
    ): String {
        var answer: String = "$general：$first，$second，$third，$forth"
        //先遍历每个数组
        for (array in otherArray) {
            //再遍历某个数组中的所有元素
            for (item in array) {
                answer = "$answer，$item"
            }
        }
        return answer
    }

}