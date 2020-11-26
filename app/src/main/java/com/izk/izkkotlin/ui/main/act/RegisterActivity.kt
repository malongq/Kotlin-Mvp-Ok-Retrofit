package com.izk.izkkotlin.ui.main.act

import android.content.Intent
import com.izk.izkkotlin.R
import com.izk.izkkotlin.base.BaseActivity
import com.izk.izkkotlin.ui.main.presenter.RegisterPresenter
import com.izk.izkkotlin.ui.main.view.RegisterView
import kotlinx.android.synthetic.main.register_activity.*

/**
 *  Created by malong on 2020/11/25
 *  功能 :  注册页面
 */
class RegisterActivity : BaseActivity<RegisterView, RegisterPresenter>(), RegisterView {

    override fun getLayoutId(): Int = R.layout.register_activity

    override fun init() {
        //跳转到发送验证码页面
        jump_to_send_code.setOnClickListener {
            startActivity(Intent(this@RegisterActivity,SendCodeActivity::class.java))
        }
    }

    override fun initData() {
    }

    override fun createPresenter(): RegisterPresenter = RegisterPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(err: String) {
    }
}