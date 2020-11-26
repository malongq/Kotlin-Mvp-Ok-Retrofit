package com.izk.izkkotlin.ui.main.presenter

import com.izk.izkkotlin.http.HttpUtils
import com.izk.izkkotlin.http.ResponseListener
import com.izk.izkkotlin.http.UserApi
import com.izk.izkkotlin.mvp.model.BaseModel
import com.izk.izkkotlin.mvp.presenter.BasePresenter
import com.izk.izkkotlin.ui.main.model.CodeModel
import com.izk.izkkotlin.ui.main.view.RegisterView

/**
 *  Created by malong on 2020/11/25
 *  功能 :
 */
class RegisterPresenter :BasePresenter<RegisterView>() {

    fun getCode(phoneNumber: String) {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getCode(phoneNumber),object :ResponseListener<BaseModel<CodeModel>>{
            override fun onSuccess(data: BaseModel<CodeModel>) {
                if (data!= null){
                    if (data.code == 100){
                        getBaseView()?.setData(data.data)
                    }
                }
            }

            override fun onFailed(err: String) {
                getBaseView()!!.setError(err)
            }

        })

    }

}