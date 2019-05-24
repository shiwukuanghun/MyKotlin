package com.wuchen.mykotlin.forest

/**
 * Time：2019/5/22 9:46
 * Author：WuChen
 * Description：
 * **/
//在类名后面加"<T>"，表示这是一个模板类
class River<T> (var name:String, var length:T) {
    fun getInfo():String{
        var unit:String = when(length) {
            is String->"米"
            //Int、Float、Double都是数字类型Number
            is Number->"m"
            else->""
        }
        return "${name}的长度是$length$unit"
    }
}