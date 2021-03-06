package com.stdio.hue.yoga.base.core;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;

import java.io.File;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by TranHuuPhuc on 4/13/18.
 */

public abstract class BaseDataBindingActivity<T extends ViewDataBinding> extends BaseActivity {

    protected T viewDataBinding;
    protected CompositeDisposable disposableManager;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        disposableManager = new CompositeDisposable();
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
    public void onResume() {
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
        disposableManager.clear();
        destroyScreen();
    }

    public Uri getExitsVideo(String videoName) {
        File file = new File(getFilesDir(), videoName);
        if (file.exists()) {
            return Uri.parse(file.getPath());
        }
        return null;
    }
}
