package com.izk.izkkotlin.ui.main.frg

import android.os.Bundle
import android.view.View
import com.izk.izkkotlin.R
import com.izk.izkkotlin.base.BaseFragment
import com.izk.izkkotlin.ui.main.presenter.HomePresenter
import com.izk.izkkotlin.ui.main.view.HomeView

/**
 *  Created by malong on 2020/11/24
 *  功能 :  主页 Fragment
 */
class MineFragment : BaseFragment<HomeView, HomePresenter>(), HomeView {

    override fun init() {
    }

    override fun initData() {
    }

    override fun createPresenter(): HomePresenter = HomePresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(err: String) {
    }

    override fun getLayout(): Int = R.layout.fragment_mine

}