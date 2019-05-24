package com.wuchen.mykotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wuchen.mykotlin.bird.*
import kotlinx.android.synthetic.main.activity_inherit.*

/**
 * Time：2019/5/16 11:09
 * Author：WuChen
 * Description：
 * **/
class InheritActivity : AppCompatActivity() {

    var count = 0
    var animalName = ""
    var animalSex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inherit)

        btn_class_bird.setOnClickListener {
            setBirdInfo()
            var bird = when(count%2) {
                0-> Bird(animalName)
                else-> Bird(animalName, animalSex)
            }
            tv_class_inherit.text=bird.getDesc("鸟语林")
            //外部无法访问private和protected的成员属性和成员方法
//            bird.getSexName(animalSex)
        }

        btn_class_duck.setOnClickListener {
            var sexBird = if (count++%3==0) Bird.MALE else Bird.FEMALE
            var duck = Duck(sex=sexBird)
            tv_class_inherit.text = duck.getDesc("鸟语林")
        }

        btn_class_ostrich.setOnClickListener {
            var sexBird = if (count++%3==0) Bird.MALE else Bird.FEMALE
            var ostrich = Ostrich(sex = sexBird)
            tv_class_inherit.text = ostrich.getDesc("鸟语林")
        }

        btn_abstract_cock.setOnClickListener {
            tv_class_inherit.text = Cock().callOut(count++%10)
        }

        btn_abstract_hen.setOnClickListener {
            tv_class_inherit.text = Hen().callOut(count++%10)
        }

        btn_interface_behavior.setOnClickListener {
            tv_class_inherit.text = when(count++%3) {
                0->Goose().fly()
                1->Goose().swim()
                else->Goose().run()
            }
        }

        btn_delegate_behavior.setOnClickListener {
            var fowl = when(count++%6) {
                //把代理类作为输入参数来创建实例
                0->WildFowl("老鹰", Bird.MALE, BehaviorFly())
                //由于sex参数是个默认参数，因此可以通过命名参数给behavior赋值
                1-> WildFowl("凤凰", behavior = BehaviorFly())
                2-> WildFowl("大雁",Bird.FEMALE,BehaviorSwin())
                3-> WildFowl("企鹅",behavior = BehaviorSwin())
                4-> WildFowl("鸵鸟",Bird.MALE,BehaviorRun())
                else->WildFowl("鸸鹋", behavior = BehaviorRun())
            }
            var action=when(count++%11) {
                in 0..3->fowl.fly()
                4,7,10->fowl.swim()
                else->fowl.run()
            }
            tv_class_inherit.text = "${fowl.name}：$action"
        }
    }

    fun setBirdInfo() {
        count++
        animalName = if (count%2==0) "孔雀" else "黄鹂"
        animalSex = if (count%3==0) Bird.MALE else Bird.FEMALE
    }

}