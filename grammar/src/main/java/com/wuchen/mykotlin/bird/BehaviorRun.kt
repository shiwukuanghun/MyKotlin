package com.wuchen.mykotlin.bird

/**
 * Time：2019/5/23 10:27
 * Author：WuChen
 * Description：
 * **/
class BehaviorRun : Behavior {
    override fun fly(): String {
        return "飞不起来"
    }

    override fun swim(): String {
        return "望洋兴叹"
    }

    override fun run(): String {
        return super.run()
    }

    override var skilledSports: String="奔跑"
}