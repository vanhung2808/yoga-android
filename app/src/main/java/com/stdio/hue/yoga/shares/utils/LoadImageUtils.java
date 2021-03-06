package com.stdio.hue.yoga.shares.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v4.widget.CircularProgressDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by TranHuuPhuc on 10/6/18.
 */
public class LoadImageUtils {
    @BindingAdapter({"loadUrl"})
    public static void setImageViewResource(ImageView imageView, String url) {
        loadImage(imageView.getContext(), url, imageView);
    }

    public static void loadImage(Context context, String url, ImageView intoView) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(3f);
        circularProgressDrawable.setCenterRadius(15f);
        circularProgressDrawable.start();
        Glide.with(context)
                .load(url)
                .apply(RequestOptions.centerInsideTransform().diskCacheStrategyOf(DiskCacheStrategy.RESOURCE).placeholder(circularProgressDrawable).error(android.R.color.darker_gray))
                .into(intoView);
    }
}
