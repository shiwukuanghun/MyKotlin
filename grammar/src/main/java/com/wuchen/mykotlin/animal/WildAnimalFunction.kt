package com.wuchen.mykotlin.animal

/**
 * Time：2019/5/16 9:21
 * Author：WuChen
 * Description：
 * **/
class WildAnimalFunction(var name:String, val sex:Int = 0) {
    var sexName:String
    init {
        sexName = if (sex==0) "公" else "母"
    }

    fun getDesc(tag:String) :String {
        return "欢迎来到$tag，这只${name}是${sexName}的"
    }
}