package com.izk.izkkotlin.ui.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.izk.izkkotlin.R
import kotlinx.android.synthetic.main.set_page_item.view.*

/**
 *  Created by malong on 2020/11/27
 *  功能 :  设置页面封装类
 */
class SetPageItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var leftTitle:String? = ""
    private var leftContent:String? = ""
    private var rightTitle:String? = ""
    private var rightImgIsShow:Boolean = false
    private var rightButtonIsShow:Boolean = false

    private val setArray:TypedArray = context.obtainStyledAttributes(attrs, R.styleable.SetPageItem)

    init{
        leftTitle = setArray.getString(R.styleable.SetPageItem_leftTitle)
        leftContent = setArray.getString(R.styleable.SetPageItem_leftContent)
        rightTitle = setArray.getString(R.styleable.SetPageItem_rightTitle)
        rightImgIsShow = setArray.getBoolean(R.styleable.SetPageItem_rightImgIsShow,false)
        rightButtonIsShow = setArray.getBoolean(R.styleable.SetPageItem_rightButtonIsShow,false)
        setArray.recycle()
        initView()
    }

    private fun initView() {
        val view: View = LayoutInflater.from(context).inflate(R.layout.set_page_item,this)
        view.tv_left.text = leftTitle
        view.tv_left_content.text = leftContent
        view.tv_right.text = rightTitle
        isShowImg(view)
        isShowImgButton(view)
    }

    private fun isShowImg(view: View) {
        if (rightImgIsShow){
            view.iv_right.visibility = View.VISIBLE
        }else{
            view.iv_right.visibility = View.GONE
        }
    }

    private fun isShowImgButton(view: View) {
        if (rightButtonIsShow){
            view.iv_right_button.visibility = View.VISIBLE
        }else{
            view.iv_right_button.visibility = View.GONE
        }
    }


}