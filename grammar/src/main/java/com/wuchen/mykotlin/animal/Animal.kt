package com.wuchen.mykotlin.animal

import android.util.Log

/**
 * Time：2019/5/14 17:09
 * Author：WuChen
 * Description：
 * **/
class Animal {

    //类的初始化函数
    init {
        //Kotlin使用println代替java的System.out.println
        println("Animal：这是个动物的类")
        //调用Android的日志类log
        Log.d("Animal", "这是个动物的类")
    }

}