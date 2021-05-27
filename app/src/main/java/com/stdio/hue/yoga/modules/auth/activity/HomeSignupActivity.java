package com.stdio.hue.yoga.modules.auth.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.databinding.ActivityHomeSignupBinding;
import com.stdio.hue.yoga.databinding.ActivityNewsDetailBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;
import com.stdio.hue.yoga.modules.newsdetail.ui.activity.NewsDetailActivity;

public class HomeSignupActivity extends BaseYogaActivity<BasePresenter, ActivityHomeSignupBinding> {

    public static void start(Context context) {
        Intent starter = new Intent(context, HomeSignupActivity.class);
        context.startActivity(starter);
    }
    private LinearLayout lnSignInWithEmail;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_signup;
    }

    @Override
    protected void init() {
        initEvent();
    }

    @Override
    protected void startScreen() {

    }

    @Override
    protected void resumeScreen() {

    }

    @Override
    protected void pauseScreen() {

    }

    @Override
    protected void destroyScreen() {

    }

    @NonNull
    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter();
    }



    public void initEvent() {

    }
}