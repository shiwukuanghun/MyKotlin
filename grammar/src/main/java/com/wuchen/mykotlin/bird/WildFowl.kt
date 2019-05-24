package com.wuchen.mykotlin.bird

/**
 * Time：2019/5/20 17:00
 * Author：WuChen
 * Description：
 * **/
//只有接口才使用关键字by进行代理操作
//如果by的对象是个类，则则编译器会报错“Only interfaces can be delegated to”
class WildFowl(name:String, sex:Int=Bird.MALE, behavior: Behavior) :Bird(name, sex),Behavior by behavior {
}