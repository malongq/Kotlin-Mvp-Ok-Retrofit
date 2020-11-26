package com.izk.izkkotlin.ui.main.frg

import android.content.Intent
import android.view.View
import com.izk.izkkotlin.R
import com.izk.izkkotlin.base.BaseFragment
import com.izk.izkkotlin.ui.main.act.RegisterActivity
import com.izk.izkkotlin.ui.main.presenter.HomePresenter
import com.izk.izkkotlin.ui.main.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 *  Created by malong on 2020/11/24
 *  功能 :  主页 Fragment
 */
class HomeFragment : BaseFragment<HomeView, HomePresenter>(), HomeView {

    override fun init() {
        tv_home2.setOnClickListener(View.OnClickListener {
            startActivity(Intent(context, RegisterActivity::class.java))
        })
    }

    override fun initData() {}

    override fun createPresenter(): HomePresenter = HomePresenter()

    override fun <T> setData(data: T) {}

    override fun setError(err: String) {}

    override fun getLayout(): Int = R.layout.fragment_home

}