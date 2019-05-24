package com.wuchen.mykotlin.forest

/**
 * Time：2019/5/21 11:34
 * Author：WuChen
 * Description：
 * **/
sealed class SeasonSealed {
    //密封类内部的每个嵌套类都必须继承该类
    class Spring(var name:String) : SeasonSealed()
    class Summer(var name:String) :SeasonSealed()
    class Autumn(var name:String) :SeasonSealed()
    class Winter(var name:String) :SeasonSealed()
}