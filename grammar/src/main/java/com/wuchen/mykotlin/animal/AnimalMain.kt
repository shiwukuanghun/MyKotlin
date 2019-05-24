package com.wuchen.mykotlin.animal

import android.content.Context
import android.util.Log
import org.jetbrains.anko.toast

/**
 * Time：2019/5/14 17:15
 * Author：WuChen
 * Description：
 * **/
//如果主构造函数没有带@符号的注解说明，则类名后面的constructor可以省略
//class AnimalMain constructor(context:Context, name:String) {
class AnimalMain (context:Context, name:String) {

    //init是主构造函数的代码,构造函数中的参数如果没被声明为属性，就只能在构造函数的函数体中使用
    init {
        context.toast("这是只$name")
        Log.e("AnimalMain", "这是只$name")
    }

    //二级构造函数从属于主构造函数，使用二级构造函数声明实例，系统会先调用主构造函数的init代码，在调用二级构造函数自身的代码
    constructor(context:Context, name:String, sex:Int) : this(context, name) {
        var sexName:String = if (sex==0) "公" else "母"
        context.toast("这只${name}是${sexName}的")
        Log.e("AnimalMain", "这只${name}是${sexName}的")
    }

}