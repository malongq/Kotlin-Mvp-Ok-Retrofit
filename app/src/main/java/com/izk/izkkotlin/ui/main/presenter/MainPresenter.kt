package com.izk.izkkotlin.ui.main.presenter

import com.izk.izkkotlin.http.HttpUtils
import com.izk.izkkotlin.http.ResponseListener
import com.izk.izkkotlin.http.UserApi
import com.izk.izkkotlin.mvp.model.BaseModel
import com.izk.izkkotlin.mvp.presenter.BasePresenter
import com.izk.izkkotlin.ui.main.model.MainModel
import com.izk.izkkotlin.ui.main.view.MainView

/**
 *  Created by malong on 2020/11/24
 *  功能 :
 */
class MainPresenter : BasePresenter<MainView>() {

    fun getTest(){
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getTest(), object :ResponseListener<BaseModel<MainModel>>{
            override fun onSuccess(data: BaseModel<MainModel>) {
                if (data != null){
                    getBaseView()!!.setData(data)
                }
            }

            override fun onFailed(err: String) {
                getBaseView()!!.setError(err)
            }

        })
    }

}