package com.wuchen.mykotlin.forest

/**
 * Time：2019/5/21 10:54
 * Author：WuChen
 * Description：
 * **/
class Tree(var treeName:String) {

    //在类内部再定义一个类，这个新类称作嵌套类
    class Flower(var flowerName:String) {
        fun getName():String {
            return "这是一朵$flowerName"
            //普通的内部类不能访问外部的成员，，如treeName
            //否则编译器报错“Unresolved reference: ***”
        }
    }

    //嵌套类加上inner前缀，就成了内部类
    inner class Fruit(var fruitName:String) {
        fun getName():String {
            //只有声明为内部类（添加了关键字inner），才能访问外部类成员
            return "这是${treeName}上长出来的$fruitName"
        }
    }

}