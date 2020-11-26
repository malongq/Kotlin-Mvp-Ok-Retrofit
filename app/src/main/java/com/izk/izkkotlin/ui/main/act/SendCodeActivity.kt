package com.izk.izkkotlin.ui.main.act

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.os.Message.obtain
import android.util.Log
import android.widget.Toast
import com.izk.izkkotlin.R
import com.izk.izkkotlin.base.BaseActivity
import com.izk.izkkotlin.base.Constants.COUNTDOWN_TIME
import com.izk.izkkotlin.base.Constants.COUNTDOWN_TIME_INVERSE
import com.izk.izkkotlin.ui.main.presenter.SendCodePresenter
import com.izk.izkkotlin.ui.main.view.SendCodeView
import com.izk.izkkotlin.ui.utils.CountDownTime
import com.izk.izkkotlin.ui.utils.CountDownTimeListener
import kotlinx.android.synthetic.main.activity_send_code.*
import java.util.logging.Handler as Handler1

class SendCodeActivity : BaseActivity<SendCodeView, SendCodePresenter>(),SendCodeView,CountDownTimeListener {

    private var mCountDownTime:CountDownTime? = null

    override fun getLayoutId(): Int = R.layout.activity_send_code

    override fun init() {
        mCountDownTime = CountDownTime(COUNTDOWN_TIME, COUNTDOWN_TIME_INVERSE,this)
        mCountDownTime?.start()
    }

    override fun initData() {
        commonGetCode()
    }

    override fun createPresenter(): SendCodePresenter = SendCodePresenter()

    override fun <T> setData(data: T) {

    }

    override fun setError(err: String) {
        Toast.makeText(this,"模拟请求成功,进入下一页面",Toast.LENGTH_LONG).show()

        // 发送一条携带Bundle对象的消息
        val mMessage = obtain()
        val mBundle = Bundle()
        mBundle.putString(NAME_KEY, "ml")
        Log.i("传入参数", "ml")
        mMessage.data = mBundle
        mHandler.sendMessage(mMessage)
        // 使用sendEmptyMessageDelayed延时1s后发送一条消息
        mHandler.sendEmptyMessageDelayed(MESSAGE_WHAT, 3000)

    }

    override fun countDown(time: Long) {
        val s = ("重新获取(${time/1000})秒")
        tv_get_re_code.text = s
        tv_get_re_code.isEnabled = false
    }

    override fun isOver(isOver: Boolean) {
        val s = "重新获取"
        tv_get_re_code.text = s
        tv_get_re_code.isEnabled = true
        tv_get_re_code.setOnClickListener{
            mCountDownTime?.start()
            commonGetCode()

        }
    }

    private fun commonGetCode() {
        getPresenter()?.getCode("18618187729")
    }

    // 静态常量
    companion object {
        const val NAME_KEY = "NAME"
        const val MESSAGE_WHAT = 1001
    }

    // 创建一个Handler
    private val mHandler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg?.what) {
                MESSAGE_WHAT -> {
                    Log.e("Kotlin", "接收通过sendEmptyMessageDelayed()发送过来的消息")
                    var intent:Intent = Intent(this@SendCodeActivity,StudyActivity::class.java)
                    var bundle = Bundle()
                    bundle.putString("name","ml")
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            }
        }
    }



}