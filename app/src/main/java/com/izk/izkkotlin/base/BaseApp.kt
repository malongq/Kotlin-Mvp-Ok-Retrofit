package com.izk.izkkotlin.base

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 *  Created by malong on 2020/11/24
 *  功能 :  Application
 */
class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }

}