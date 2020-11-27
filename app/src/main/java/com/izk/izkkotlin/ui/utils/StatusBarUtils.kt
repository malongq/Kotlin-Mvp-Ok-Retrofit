package com.izk.izkkotlin.ui.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.izk.izkkotlin.base.Constants.HOME_BAR

/**
 *  Created by malong on 2020/11/25
 *  功能 :  状态栏设置类
 */
object StatusBarUtils {

    private var falg: Int = View.SYSTEM_UI_FLAG_LAYOUT_STABLE

    fun setStatusBar(act: Activity, type: Int, colorId: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//系统版本大于等于5.0
            if (type == HOME_BAR) {
                act.window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR//状态栏字体颜色为白色
            } else {
                act.window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//状态栏字体颜色为黑色
            }
            act.window.statusBarColor = ContextCompat.getColor(act, colorId)//状态栏颜色
        }
    }

    fun setStatusBar2(act: Activity, type: Int, colorId: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//系统版本大于等于5.0
            val window = act.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                falg = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }
            act.window.decorView.systemUiVisibility = falg
            //设置暗色,文字为深色背景透明view,SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            //设置亮色,文字为白色背景透明view,SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            setUiVisbility(window,type)
            setColor(window,ContextCompat.getColor(act,colorId))
        }
    }

    private fun setUiVisbility(window: Window, type: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            window.decorView.systemUiVisibility = type
        }
    }

    private fun setColor(window: Window, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            window.statusBarColor = color
        }
    }



}