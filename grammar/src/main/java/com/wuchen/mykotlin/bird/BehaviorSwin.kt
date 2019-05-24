package com.wuchen.mykotlin.bird

/**
 * Time：2019/5/23 10:25
 * Author：WuChen
 * Description：
 * **/
class BehaviorSwin : Behavior {
    override fun fly(): String {
        return "看情况，大雁能展翅高飞，企鹅却欲飞还休"
    }

    override fun swim(): String {
        return "怡然戏水"
    }

    override fun run(): String {
        return "赶鸭子上树"
    }

    override var skilledSports: String = "游泳"
}