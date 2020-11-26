package com.izk.izkkotlin.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.izk.izkkotlin.R
import com.izk.izkkotlin.base.Constants.COMMON_BAR
import com.izk.izkkotlin.base.Constants.HOME_BAR
import com.izk.izkkotlin.mvp.presenter.BasePresenter
import com.izk.izkkotlin.mvp.view.BaseView
import com.izk.izkkotlin.ui.utils.StatusBarUtils

/**
 *  Created by malong on 2020/11/24
 *  功能 :
 */
abstract class BaseActivity<V, P: BasePresenter<V> > : AppCompatActivity(), BaseView {

    private var mPresenter: P ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        StatusBarUtils.setStatusBar(this, HOME_BAR, R.color.colorPrimary)//设置状态栏字体颜色为白色,状态栏颜色为蓝色
        if (mPresenter == null){
            mPresenter = createPresenter()
        }
        mPresenter!!.bindView(this as V)
        init()
        initData()
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun init()
    protected abstract fun initData()
    protected abstract fun createPresenter() : P

    fun getPresenter() = mPresenter

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unbindView()
    }

}