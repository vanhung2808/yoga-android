package com.stdio.hue.yoga.modules.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.stdio.hue.yoga.ProjectApplication;
import com.stdio.hue.yoga.base.core.BaseViperActivity;
import com.stdio.hue.yoga.base.core.mvp.Presenter;
import com.stdio.hue.yoga.di.components.AppComponent;
import com.stdio.hue.yoga.shares.widget.LoadingDialog;

/**
 * Created by TranHuuPhuc on 7/6/18.
 */
public abstract class BaseYogaActivity<P extends Presenter, V extends ViewDataBinding> extends BaseViperActivity<P> {
    protected V viewDataBinding;

    protected LoadingDialog loadingDialog;

    protected void showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        loadingDialog.show();
    }

    protected void hideLoadingDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    protected void loading(boolean show) {
        if (show) {
            showLoadingDialog();
        } else {
            hideLoadingDialog();
        }
    }

    /**
     * setup content layout
     *
     * @return layout id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * init for data
     */
    protected abstract void init();

    /**
     * start screen
     */
    protected abstract void startScreen();

    /**
     * resume screen
     */
    protected abstract void resumeScreen();

    /**
     * pause screen
     */
    protected abstract void pauseScreen();

    /**
     * destroy screen
     */
    protected abstract void destroyScreen();

    protected AppComponent getAppComponent() {
        return ((ProjectApplication) getApplication()).getAppComponent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        init();
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        startScreen();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startScreen();
    }

    @Override
    protected void onResume() {
        super.onResume();
        resumeScreen();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pauseScreen();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyScreen();
    }

}
