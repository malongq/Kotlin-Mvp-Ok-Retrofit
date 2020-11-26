package com.izk.izkkotlin.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by malong on 2020/11/24
 * 功能 :  主页fragment不滑动切换
 */
public class ScrollNotViewPage extends ViewPager {

    public ScrollNotViewPage(@NonNull Context context) {
        super(context);
    }

    public ScrollNotViewPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
