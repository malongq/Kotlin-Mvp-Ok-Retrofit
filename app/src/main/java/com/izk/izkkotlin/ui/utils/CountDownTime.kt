package com.izk.izkkotlin.ui.utils

import android.os.CountDownTimer

/**
 *  Created by malong on 2020/11/26
 *  功能 :  倒计时
 */
class CountDownTime(millisInFuture: Long, countDownInterval: Long,countDownTimeListener: CountDownTimeListener) : CountDownTimer(millisInFuture, countDownInterval) {

    private var countDownTimeListener: CountDownTimeListener = countDownTimeListener

    override fun onFinish() {
        countDownTimeListener.isOver(true)
    }

    override fun onTick(millisUntilFinished: Long) {
        countDownTimeListener.isOver(false)
        countDownTimeListener.countDown(millisUntilFinished)
    }
}