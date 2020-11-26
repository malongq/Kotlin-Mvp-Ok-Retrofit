package com.izk.izkkotlin.ui.main.act

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.izk.izkkotlin.R
import com.izk.izkkotlin.base.BaseActivity
import com.izk.izkkotlin.base.Constants.COMMON_BAR
import com.izk.izkkotlin.ui.main.adapter.TabAdapter
import com.izk.izkkotlin.ui.main.frg.HomeFragment
import com.izk.izkkotlin.ui.main.frg.MineFragment
import com.izk.izkkotlin.ui.main.frg.SelectFragment
import com.izk.izkkotlin.ui.main.frg.StudyFragment
import com.izk.izkkotlin.ui.main.model.TitleModel
import com.izk.izkkotlin.ui.main.presenter.MainPresenter
import com.izk.izkkotlin.ui.main.view.MainView
import com.izk.izkkotlin.ui.utils.StatusBarUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    private val titleTabs = ArrayList<CustomTabEntity>()
    private val fragments = ArrayList<Fragment>()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun init() {

        StatusBarUtils.setStatusBar(this, COMMON_BAR, R.color.c_cd0014)//设置状态栏字体颜色为黑色,状态栏颜色为红色

        //主页tab
        val titles = resources.getStringArray(R.array.title)
        val selectIds = resources.obtainTypedArray(R.array.select)
        val unSelectIds = resources.obtainTypedArray(R.array.unselect)
        for (i: Int in titles.indices) {
            titleTabs.add(
                TitleModel(
                    titles[i],
                    unSelectIds.getResourceId(i, 0),
                    selectIds.getResourceId(i, 0)
                )
            )
        }
        fragments.add(HomeFragment())
        fragments.add(SelectFragment())
        fragments.add(StudyFragment())
        fragments.add(MineFragment())
        vp_home.offscreenPageLimit = fragments.size
        vp_home.adapter = TabAdapter(supportFragmentManager, fragments)
        ctl_home.setTabData(titleTabs)
        ctl_home.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                vp_home.setCurrentItem(position, false)
            }

            override fun onTabReselect(position: Int) {}
        })
    }

    override fun initData() {}

    override fun createPresenter() = MainPresenter()

    override fun <T> setData(data: T) {
        Log.e("test", "========>$data")
    }

    override fun setError(err: String) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show()
    }
}