package com.izk.izkkotlin.ui.main.presenter

import com.izk.izkkotlin.http.HttpUtils
import com.izk.izkkotlin.http.ResponseListener
import com.izk.izkkotlin.http.UserApi
import com.izk.izkkotlin.mvp.model.BaseModel
import com.izk.izkkotlin.mvp.presenter.BasePresenter
import com.izk.izkkotlin.ui.main.model.CodeModel
import com.izk.izkkotlin.ui.main.view.SendCodeView
import com.izk.izkkotlin.ui.main.view.SetView

/**
 *  Created by malong on 2020/11/26
 *  功能 :
 */
class SetPresenter :BasePresenter<SetView>() {

    fun getCode(phoneNumber: String) {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getCode(phoneNumber),object :
            ResponseListener<BaseModel<CodeModel>> {
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