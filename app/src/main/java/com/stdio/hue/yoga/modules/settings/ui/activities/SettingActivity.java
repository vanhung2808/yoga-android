package com.stdio.hue.yoga.modules.settings.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.databinding.ActivitySettingsBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;

/**
 * Created by TranHuuPhuc on 11/29/18.
 */
public class SettingActivity extends BaseYogaActivity<BasePresenter, ActivitySettingsBinding> {
    public static void start(Context context) {
        Intent starter = new Intent(context, SettingActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }

    @Override
    protected void init() {
        viewDataBinding.toolbar.setNavigationIcon(R.drawable.ic_back_green);
        viewDataBinding.toolbar.setTitle(R.string.settings);
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initData();
    }

    private void initData() {
        viewDataBinding.cellCollectionClasses.setKey(getString(R.string.collection_classes));
        viewDataBinding.cellCollectionClasses.setValue("Teacher");
        viewDataBinding.cellCustomerClasses.setKey(getString(R.string.customer_classes));
        viewDataBinding.cellCustomerClasses.setValue("Poses Name");
        viewDataBinding.cellMusic.setKey(getString(R.string.music));
        viewDataBinding.cellMusic.setValue("Ambient Flute");
        viewDataBinding.cellShowProgressBar.setKey(getString(R.string.show_progress_bar));
        viewDataBinding.cellSwipeToSkipPose.setKey(getString(R.string.swipe_to_skip_pose));
        viewDataBinding.cellAlert.setKey(getString(R.string.alert));
        viewDataBinding.cellAlert.setValue("At start time");
        viewDataBinding.cellHealthApp.setKey(getString(R.string.health_app));
        viewDataBinding.cellHealthApp.setValue("Not Connected");
        viewDataBinding.cellJawboneUp.setKey(getString(R.string.jawbone_up));
        viewDataBinding.cellJawboneUp.setValue("Not Connected");
        viewDataBinding.cellCelluraData.setKey(getString(R.string.cellura_data));
        viewDataBinding.cellSentReport.setKey(getString(R.string.sent_report));
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
