package com.izk.izkkotlin.ui.utils

/**
 *  Created by malong on 2020/11/26
 *  功能 :  倒计时接口
 */
interface CountDownTimeListener {
    fun countDown(time:Long)
    fun isOver(isOver:Boolean)
}