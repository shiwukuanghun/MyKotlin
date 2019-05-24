package com.wuchen.mykotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_null.*

/**
 * Time：2019/5/14 9:34
 * Author：WuChen
 * Description：
 * **/
class NullActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null)

        val strA: String = "非空"
        val strB: String? = null
        val strC: String? = "可空串"

        tv_check_title.text = "A为$strA，B为$strB，C为$strC"

        //Java在Android中的字符串空值校验函数为TextUtils.isEmpty(str)
        //strA.isNullOrEmpty() //非空串与可空串均可调用，为空指针或者字串长度为0时返回true
        //strA.isNullOrBlank() //非空串与可空串均可调用，为空指针或者字串长度为0或者全为空格时返回true
        //strA.isEmpty() //只有非空串可调用，字串长度为0时返回true
        //strA.isBlank() //只有非空串可调用，字串长度为0或者全为空格时返回true
        //strA.isNotEmpty() //只有非空串可调用，字串长度大于0时返回true
        //strA.isNotBlank() //只有非空串可调用，字串长度大于0且不是全空格串时返回true

        btn_judge_a.setOnClickListener {
            tv_check_result.text = "字符串A的空值校验结果是${strA.isBlank()}"
        }
        btn_judge_b.setOnClickListener {
            tv_check_result.text="字符串B的空值校验结果是${strB.isNullOrBlank()}"
        }
        btn_judge_c.setOnClickListener {
            tv_check_result.text="字符串C的空值校验结果是${strC.isNullOrBlank()}"
        }

        var length : Int = 0
        btn_length_a.setOnClickListener {
            length = strA.length
            tv_check_result.text = "字符串A的长度为$length"
        }
        btn_length_b.setOnClickListener {
//            length = strB.length //这种写法是不行的，因为strB可能为空，会扔出空指针异常
            length = if (strB != null) strB.length else -1
            tv_check_result.text = "字符串B的长度为$length"
        }
        btn_length_c.setOnClickListener {
            //即使strC实际有值，也必须做非空判断，谁叫它号称可空呢？编译器宁可错杀一千、不可放过一个
            length = if (strC!=null) strC.length else -1
            tv_check_result.text = "字符串B的长度为$length"
        }

        var length_null:Int? //声明为可控类型
        btn_question_dot.setOnClickListener {
            //?.表示对象为空时直接返回null，所以返回值的变量必须被生命为可空类型
            length_null = strB?.length
            tv_check_result.text="使用?.得到字符串strB的长度为$length_null"
        }
        btn_question_colon.setOnClickListener {
            //?:表示为空时就返回右边的值，即(x!=null)?x.**:y
            length_null = strB?.length?:-1
            tv_check_result.text = "使用?:得到字符串strB的长度为$length_null"
        }
        btn_exclamation_two.setOnClickListener {
            //!!表示不做非空判断，强制执行后面的表达式，如果对象为空就会扔出空异常
            //所以只有在确保为非空时，才能使用!!，否则会抛出异常
            try {
                length = strB!!.length
                tv_check_result.text = "使用!!得到字符串B的长度为$length"
            } catch (e: Exception) {
                tv_check_result.text = "发现空指针异常"
            }
        }
    }

}