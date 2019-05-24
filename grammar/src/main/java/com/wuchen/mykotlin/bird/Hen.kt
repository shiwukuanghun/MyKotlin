package com.wuchen.mykotlin.bird

/**
 * Time：2019/5/20 15:26
 * Author：WuChen
 * Description：
 * **/
class Hen(name:String="鸡",sex:Int = Bird.FEMALE, voice:String="咯咯咯"):Chicken(name, sex, voice) {
    override fun callOut(times: Int): String {
        var count = when{
            times<=0->0
            times>=10->9
            else->times
        }
        return "$sexName$name${voice}叫了${numberArray[count]}声，原来它要下蛋了"
    }


}