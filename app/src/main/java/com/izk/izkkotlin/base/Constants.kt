package com.izk.izkkotlin.base

/**
 *  Created by malong on 2020/11/24
 *  功能 :  常量配置类
 */
object Constants {

    //网络访问主地址
    const val BASE_URL = "http://toutiao.apkbus.com/wp-json/custom/v1/"
    const val BASE_URL_TEST = "http://toutiao.apkbus.com/wp-json/custom/v1/"

    //状态栏字体及背景颜色
    const val HOME_BAR = 1//状态栏字体颜色为白色
    const val COMMON_BAR = 2//状态栏字体颜色为黑色

    //倒计时时间设置
    const val COUNTDOWN_TIME:Long = 60 * 1000//倒计时60秒
    const val COUNTDOWN_TIME_INVERSE:Long = 1000//倒计时1秒 单位

}