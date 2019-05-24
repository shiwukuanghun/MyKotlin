package com.wuchen.mykotlin.animal

/**
 * Time：2019/5/16 10:55
 * Author：WuChen
 * Description：
 * **/
class WildAnimalConstant(var name:String, val sex:Int = 0) {

    var sexName:String
    init {
        sexName = if (sex==0) "公" else "母"
    }

    fun getDesc(tag:String) :String{
        return "欢迎来到${tag}，这只${name}是${sexName}的"
    }

    companion object {
        //静态常量的值是不可变的，所以要用val修饰
        val MALE:Int = 0
        val FEMAL:Int = 1
        val UNKNOW:Int = -1
        fun judgSex(sexName:String):Int {
            return when(sexName) {
                "公","雄"-> MALE
                "母","雌"-> FEMAL
                else-> UNKNOW
            }
        }
    }
}