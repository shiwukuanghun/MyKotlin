package com.wuchen.mykotlin.animal

/**
 * Time：2019/5/16 10:38
 * Author：WuChen
 * Description：
 * **/
class WildAnimalCompanion(var name: String, val sex: Int = 0) {

    var sexName: String

    init {
        sexName = if (sex == 0) "公" else "母"
    }

    fun getDesc(tag:String):String {
        return "欢迎来到${tag}，这只${name}是${sexName}的"
    }

    //在类加载时就运行伴生对象的代码块，其作用相当于Java里的static{...}代码块
    //关键字companian表示伴随，object表示对象，WildAnimal表示伴生对象的名称，伴生对象名称可以省略不写
    companion object WildAnimal {
        fun judgeSex(sexName:String):Int {
            var sex:Int = when(sexName) {
                "公","雄"->0
                "母","雌"->1
                else->-1
            }
            return sex
        }
    }

}