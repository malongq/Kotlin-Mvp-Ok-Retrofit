package com.izk.izkkotlin.ui.utils

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.core.content.ContextCompat
import com.izk.izkkotlin.base.Constants.HOME_BAR

/**
 *  Created by malong on 2020/11/25
 *  功能 :  状态栏设置类
 */
object StatusBarUtils {

    fun setStatusBar(act:Activity, type:Int, colorId:Int){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){//系统版本大于等于5.0
            if (type == HOME_BAR){
                act.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR//状态栏字体颜色为白色
            }else{
                act.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//状态栏字体颜色为黑色
            }
            act.window.statusBarColor = ContextCompat.getColor(act,colorId)//状态栏颜色
        }
    }

}