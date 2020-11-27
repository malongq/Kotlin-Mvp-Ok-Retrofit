package com.izk.izkkotlin.ui.main.frg

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.izk.izkkotlin.R
import com.izk.izkkotlin.base.BaseFragment
import com.izk.izkkotlin.ui.main.act.SetActivity
import com.izk.izkkotlin.ui.main.presenter.HomePresenter
import com.izk.izkkotlin.ui.main.view.HomeView
import kotlinx.android.synthetic.main.fragment_select.*

/**
 *  Created by malong on 2020/11/24
 *  功能 :  选课 Fragment
 */
class SelectFragment : BaseFragment<HomeView, HomePresenter>(), HomeView {

    override fun init() {
        tv_select.setOnClickListener {
            startActivity(Intent(context, SetActivity::class.java))
        }
    }

    override fun initData() {
    }

    override fun createPresenter(): HomePresenter = HomePresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(err: String) {
    }

    override fun getLayout(): Int = R.layout.fragment_select

}