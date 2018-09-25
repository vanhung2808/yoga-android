package com.stdio.hue.yoga.common.widgets.slider.library.Transformers;

import android.view.View;

public class BackgroundToForegroundTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        final float height = view.getHeight();
        final float width = view.getWidth();
        final float scale = min(position < 0 ? 1f : Math.abs(1f - position));

        view.setScaleX(scale);
        view.setScaleY(scale);
        view.setPivotX(width * 0.5f);
        view.setPivotY(height * 0.5f);
        view.setTranslationX(position < 0 ? width * position : -width * position * 0.25f);
    }

    private static final float min(float val) {
        return val < 0.5f ? 0.5f : val;
    }

}
