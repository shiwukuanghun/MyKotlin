package com.wuchen.mykotlin.bird

/**
 * Time：2019/5/20 13:53
 * Author：WuChen
 * Description：
 * **/
class Ostrich(name:String = "鸵鸟", sex:Int = MALE ) : Bird(name, sex) {
    //继承protected的方法，标准写法是“override protected”
    //不过protected的方法继承过来默认就是protected，所以也可直接省略protected
    //override fun getSexName(sex:Int):String {
    //protected的方法继承之后允许将可见性升级为public，但不能降级为private
    override fun getSexName(sex: Int): String {
        return if (sex== MALE) "雄" else "雌"
    }

}