package com.wuchen.mykotlin.util

/**
 * Time：2019/5/14 14:12
 * Author：WuChen
 * Description：
 * **/
//kotlin允许定义全局函数，即函数可以在单独的kt文件中定义，然后其他地方也可以直接调用
fun <T> appendString(tag: String, vararg otherInfo: T?): String {
    var str: String = "$tag："
    //遍历可变参数中的泛型变量，将其转换成字符串再拼接到一起
    for (item in otherInfo) {
        str = "$str${item.toString()}，"
    }
    return str
}

//如果函数内容比较简单，就可以省略大括号，比如下面这个阶乘函数计算n!的结果
fun factorial(n: Int): Int = if (n <= 1) n else n * factorial(n - 1)

tailrec fun findFixPoint(x: Double = 1.0): Double = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))

fun <T> maxCustom(array: Array<T>, greater: (T, T) -> Boolean): T? {
    var max:T?=null
    for (item in array) {
        if (max == null || greater(item, max))
            max = item
    }
    return max
}