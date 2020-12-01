package com.izk.izkkotlin.ui.main.frg

import com.izk.izkkotlin.R
import com.izk.izkkotlin.base.BaseFragment
import com.izk.izkkotlin.ui.main.presenter.HomePresenter
import com.izk.izkkotlin.ui.main.view.HomeView
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 *  Created by malong on 2020/11/24
 *  功能 :  主页 Fragment
 */
class MineFragment : BaseFragment<HomeView, HomePresenter>(), HomeView {

    override fun init() {
//        rv_1.adapter =
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