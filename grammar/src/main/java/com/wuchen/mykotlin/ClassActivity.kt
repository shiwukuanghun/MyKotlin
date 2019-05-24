package com.wuchen.mykotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wuchen.mykotlin.animal.Animal
import com.wuchen.mykotlin.animal.AnimalDefault
import com.wuchen.mykotlin.animal.AnimalMain
import com.wuchen.mykotlin.animal.AnimalSeparate
import kotlinx.android.synthetic.main.activity_class.*

/**
 * Time：2019/5/14 17:06
 * Author：WuChen
 * Description：
 * **/
class ClassActivity :AppCompatActivity() {
    var count = 0
    var animalName = ""
    var animalSex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)

        btn_class_simple.setOnClickListener {
//            var animal:Animal = Animal()
            //因为根据等号后面的构造函数已经明确知道这是个Animal的实例
            //所以声明对象时可以不用指定它的类型
            var animal = Animal()
            tv_class_init.text = "简单类的初始化结果见日志"
        }

        btn_class_main.setOnClickListener {
            setAnimalInfo()
            when(count%2) {
                0->{var animal = AnimalMain(this, animalName)}
                else->{var animal = AnimalMain(this, animalName, animalSex);}
            }
        }

        btn_class_seperate.setOnClickListener {
            setAnimalInfo()
            when(count%2) {
                0->{var animal = AnimalSeparate(this, animalName)}
                else->{var animal = AnimalSeparate(this, animalName, animalSex)}
            }
        }

        btn_class_default.setOnClickListener {
            setAnimalInfo()
            when(count%2) {
                0->{var animal = AnimalDefault(this, animalName)}
                1->{var animal = AnimalDefault(this, animalName, animalSex)}
            }
        }
    }

    fun setAnimalInfo() {
        count++
        animalName = if (count%2==0) "老虎" else "斑马"
        animalSex = if (count%3==0) 0 else 1
        tv_class_init.text = "这只${animalName}是${if (animalSex==0)"公" else "母"}的"
    }

}