package com.izk.izkkotlin.ui.main.act

import com.izk.izkkotlin.R
import com.izk.izkkotlin.base.BaseActivity
import com.izk.izkkotlin.ui.main.presenter.SetPresenter
import com.izk.izkkotlin.ui.main.view.SetView

class SetActivity : BaseActivity<SetView, SetPresenter>(),SetView {

    override fun getLayoutId(): Int = R.layout.activity_set

    override fun init() {
    }

    override fun initData() {
    }

    override fun createPresenter(): SetPresenter = SetPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(err: String) {
    }
}