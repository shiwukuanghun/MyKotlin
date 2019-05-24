package com.wuchen.simple

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_forget.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast

/**
 * Time：2019/5/24 11:56
 * Author：WuChen
 * Description：
 * **/
class LoginForgetActivity : AppCompatActivity() {

    private var mVerifyCode:String?=null
    private var mPhone:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_forget)
        btn_verifycode.setOnClickListener { getVerifyCode() }
        btn_confirm.setOnClickListener { doConfirm() }
        mPhone = intent.getStringExtra("phone")
    }

    private fun getVerifyCode() {
        if (mPhone==null||mPhone!!.length<11) {
            toast("请输入正确的手机号")
            return
        }
        mVerifyCode = String.format("%06d", (Math.random() * 1000000 % 1000000).toInt())
        alert("手机号$mPhone，本次验证码是$mVerifyCode，请输入验证码", "请记住验证码") {
            positiveButton("好的") {  }
        }.show()
    }

    private fun doConfirm() {
        val password_first = et_password_first.text.toString()
        val password_second = et_password_second.text.toString()
        if (password_first.isBlank()||password_first.length<6||password_second.isBlank()||password_second.length<6) {
            toast("请输入正确的新密码")
            return
        }else if (password_first!=password_second) {
            toast("两次密码不一致")
            return
        }else if (et_verifycode.text.toString()!=mVerifyCode) {
            toast("验证码错误")
            return
        } else{
            toast("密码修改成功")
            //携带修改后的新密码返回主登录页面
            val intent = Intent().putExtra("new_password", password_first)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}