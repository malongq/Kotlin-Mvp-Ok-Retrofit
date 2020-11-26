package com.izk.izkkotlin.http

import com.izk.izkkotlin.base.Constants.BASE_URL
import com.izk.izkkotlin.base.Constants.BASE_URL_TEST
import com.orhanobut.logger.Logger
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  Created by malong on 2020/11/24
 *  功能 :  网络访问类
 */
object HttpUtils {

    private fun isTest(isTest: Boolean): String = if (isTest) BASE_URL_TEST else BASE_URL // 返回项目主地址
    private var mOkHttp: OkHttpClient? = null

    //创建一个网络请求
    fun <T> createApi(clazz: Class<T>): T = Retrofit.Builder()
        .baseUrl(isTest(true))
        .client(getClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(clazz)

    //配置Client
    private fun getClient(): OkHttpClient? {
        if (mOkHttp == null) {
            mOkHttp = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
        }
        return mOkHttp
    }

    //配置拦截日志形式
    private fun getInterceptor(): Interceptor {
        HttpLoggingInterceptor.Logger {
            Logger.json(it)
        }
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    //为外部提供一个构建Http请求的方法
    fun <T> sendHttp(ob: Observable<T>, listener: ResponseListener<T>){
        ob.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<T> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: T) {
                    listener.onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    listener.onFailed(e.message.toString())
                }

            })
    }

}