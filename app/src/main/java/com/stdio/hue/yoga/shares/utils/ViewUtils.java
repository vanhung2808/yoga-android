package com.stdio.hue.yoga.shares.utils;

import android.view.View;

/**
 * Created by dungbeo on 12/24/2019.
 */
public class ViewUtils {
    public static void setOnDelayClick(View view, View.OnClickListener delayClick) {
        view.setOnClickListener(v -> {
            view.setClickable(false);
            delayClick.onClick(v);
            view.postDelayed(() -> view.setClickable(true), 600);
        });
    }
}
