package com.stdio.hue.yoga.modules.upgrade.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.databinding.ActivityUpgradeBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;

/**
 * Created by TranHuuPhuc on 11/29/18.
 */
public class UpgradeActivity extends BaseYogaActivity<BasePresenter, ActivityUpgradeBinding> {
    public static void start(Context context) {
        Intent starter = new Intent(context, UpgradeActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upgrade;
    }

    @Override
    protected void init() {
        viewDataBinding.toolbar.setNavigationIcon(R.drawable.ic_back_white);
        viewDataBinding.toolbar.setTitle("");
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
}
