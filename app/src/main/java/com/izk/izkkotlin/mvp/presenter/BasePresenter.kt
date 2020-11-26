package com.izk.izkkotlin.mvp.presenter

/**
 *  Created by malong on 2020/11/24
 *  功能 : BasePresenter 基类
 */
open class BasePresenter<V> {
    private var mBaseView: V? = null//?表示当前参数可以为null

    fun bindView(mBaseView: V){
        this.mBaseView = mBaseView
    }

    fun unbindView(){
        this.mBaseView = null
    }

    fun getBaseView() = mBaseView
}