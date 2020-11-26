package com.izk.izkkotlin.http

import com.izk.izkkotlin.mvp.model.BaseModel
import com.izk.izkkotlin.ui.main.model.CodeModel
import com.izk.izkkotlin.ui.main.model.MainModel
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 *  Created by malong on 2020/11/24
 *  功能 :  网络请求地址
 */
interface UserApi {

    @GET("wxarticle/chapters/json")
    fun getTest():Observable<BaseModel<MainModel>>

    @FormUrlEncoded
    @POST("user/news/sendCode")
    fun getCode(@Field("phoneNumber")phone:String):Observable<BaseModel<CodeModel>>

}