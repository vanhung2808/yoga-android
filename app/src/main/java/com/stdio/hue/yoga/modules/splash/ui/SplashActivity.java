package com.stdio.hue.yoga.modules.splash.ui;

import android.annotation.SuppressLint;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;
import com.stdio.hue.yoga.modules.main.ui.activities.MainActivity;
import com.stdio.hue.yoga.modules.splash.presenter.SplashPresenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by hung.nguyendk on 4/29/18.
 */
public class SplashActivity extends BaseYogaActivity<SplashPresenter, ViewDataBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void startScreen() {
    }

    @SuppressLint("RxSubscribeOnError")
    @Override
    protected void resumeScreen() {
        disposableManager.add(isInternetOn().subscribe(result -> {
            if (getPreferences(MODE_PRIVATE).getBoolean("new", false)) {
                if (result) {
                    //Todo fetch new database change if have.
                } else {
                    disposableManager.add(Observable.just(true).delay(1500, TimeUnit.MILLISECONDS).subscribe(v -> {
                        MainActivity.start(this);
                        finish();
                    }));
                }
            } else {
                if (result) {
                    getPreferences(MODE_PRIVATE).edit().putBoolean("new", true);
                    //Todo fetch all database and create localdb.
                    getPresenter().getAllDataAndSaveLocal(null, "en");
                    MainActivity.start(this);
                    finish();
                } else {
                    showToast("Could not load data. Please connect to the network and restart the application.");
                }
            }
        }));

    }

    @Override
    protected void pauseScreen() {

    }

    @Override
    protected void destroyScreen() {

    }

    @NonNull
    @Override
    protected SplashPresenter createPresenter() {
        return getAppComponent().getSplashComponent().getSplashPresenter();
    }
}
