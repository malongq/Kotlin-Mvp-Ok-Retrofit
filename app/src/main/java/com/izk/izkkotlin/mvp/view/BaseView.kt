package com.izk.izkkotlin.mvp.view

/**
 *  Created by malong on 2020/11/24
 *  功能 :  BaseView  基类
 */
interface BaseView {
    fun <T> setData(data: T)
    fun setError(err: String)
}