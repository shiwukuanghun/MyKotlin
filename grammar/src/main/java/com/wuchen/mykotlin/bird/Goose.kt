package com.wuchen.mykotlin.bird

/**
 * Time：2019/5/20 16:36
 * Author：WuChen
 * Description：
 * **/
class Goose(name:String="鹅", sex:Int=Bird.MALE) :Bird(name, sex), Behavior {

    override fun fly(): String {
        return "鹅能飞一点点，但飞不高，也飞不远。"
    }

    override fun swim(): String {
        return "鹅，鹅，鹅，曲项向天歌。白毛浮绿水，红掌拨清波。"
    }

    override fun run(): String {
        //super用来调用父类的属性或方法，由于Kotlin的接口允许实现方法，因此super所指的对象也可以是interface
        return super.run()
    }

//    override var skilledSports: String = "游泳"

    override var skilledSports: String
        get() = "游泳"
        set(value) {}
}