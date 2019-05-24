package com.wuchen.mykotlin.bird

/**
 * Time：2019/5/16 11:13
 * Author：WuChen
 * Description：
 * **/
//Kotlin的类默认是不能继承的（即final类型），如果需要继承某类，则父类应该声明为open类型
//否则编译器会报错“The type is final, so it cannot be inherited from”。
open class Bird(var name:String, val sex:Int = 0) {

    //变量、方法、类默认都是public，所以一般都把public省略掉了
    var sexName:String
    init {
        sexName = if (sex == 0) "公" else "母"
    }

    fun getDesc(tag:String):String {
        return "欢迎来到${tag}，这只${name}是${sexName}的"
    }

    //私有方法既不能被外部访问，也不能被子类继承，因此open与private不能共存
    //否则编译器会报错：Modifier 'open' is incompatible with 'private'
    open  fun getSexName(sex:Int):String{
        return if (sex == MALE) "公" else "母"
    }

    companion object {
        val MALE:Int=0
        val FEMALE:Int=1
        val UNKNOW:Int=-1
        fun judgSex(sexName: String):Int {
            return when(sexName) {
                "公","雄"-> MALE
                "母","雌"-> FEMALE
                else-> UNKNOW
            }
        }
    }
}