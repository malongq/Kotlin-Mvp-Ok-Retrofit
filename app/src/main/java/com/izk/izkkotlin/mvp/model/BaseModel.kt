package com.izk.izkkotlin.mvp.model

/**
 *  Created by malong on 2020/11/24
 *  功能 :  BaseModel  基类
 */
data class BaseModel<T>(val code: Int, val message: String, val data: T) {}