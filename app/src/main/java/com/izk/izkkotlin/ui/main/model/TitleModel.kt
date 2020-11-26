package com.izk.izkkotlin.ui.main.model

import com.flyco.tablayout.listener.CustomTabEntity

/**
 *  Created by malong on 2020/11/24
 *  功能 :  主页tab model
 */
data class TitleModel(val title: String, val select: Int, val unSelect: Int) : CustomTabEntity {
    override fun getTabUnselectedIcon(): Int = unSelect

    override fun getTabSelectedIcon(): Int = select

    override fun getTabTitle(): String = title
}