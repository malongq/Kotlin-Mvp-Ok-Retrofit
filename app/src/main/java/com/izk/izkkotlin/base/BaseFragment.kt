package com.izk.izkkotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.izk.izkkotlin.mvp.presenter.BasePresenter
import com.izk.izkkotlin.mvp.view.BaseView

/**
 *  Created by malong on 2020/11/24
 *  功能 :
 */
abstract class BaseFragment<V, P: BasePresenter<V>> : Fragment(), BaseView {

    private var mPresenter: P? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(),container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }
        mPresenter!!.bindView(this as V)
        init()
        initData()
    }

    protected abstract fun getLayout(): Int
    protected abstract fun init()
    protected abstract fun initData()
    protected abstract fun createPresenter(): P

    fun getPresenter() = mPresenter

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unbindView()
    }
}