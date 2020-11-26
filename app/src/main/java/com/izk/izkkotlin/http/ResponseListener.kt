package com.izk.izkkotlin.http

//数据请求回调
interface ResponseListener<T> {
    fun onSuccess(data:T)
    fun onFailed(err:String)
}
