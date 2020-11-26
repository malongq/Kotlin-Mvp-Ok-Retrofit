package com.izk.izkkotlin.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *  Created by malong on 2020/11/24
 *  功能 :  主页tab 的 fragment
 */
class TabAdapter(fm:FragmentManager, fragments:ArrayList<Fragment>) : FragmentPagerAdapter(fm) {

    private val fragments:ArrayList<Fragment> = fragments

    override fun getItem(position: Int): Fragment = fragments!!.get(position)

    override fun getCount(): Int = fragments.size

}