package com.stdio.hue.yoga.common.widgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class ViewPagerNotScroll extends ViewPager {

    private boolean isPagingEnabled;

    public ViewPagerNotScroll(Context context) {
        super(context);
        isPagingEnabled = false;
    }

    public ViewPagerNotScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
        isPagingEnabled = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }
}