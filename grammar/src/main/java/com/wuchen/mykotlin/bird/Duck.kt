package com.wuchen.mykotlin.bird

/**
 * Time：2019/5/16 16:35
 * Author：WuChen
 * Description：
 * **/
//注意父类Bird已经在构造函数声明了属性，故而子类Duck无需重复声明属性
//也就是说，子类的构造函数在输入参数前不再需要加val和var
class Duck(name:String="鸭子", sex:Int= MALE) : Bird(name, sex) {
}