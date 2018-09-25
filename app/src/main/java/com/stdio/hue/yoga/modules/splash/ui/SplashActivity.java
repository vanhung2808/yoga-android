package com.stdio.hue.yoga.modules.splash.ui;

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

    @Override
    protected void resumeScreen() {
        disposableManager.add(Observable.just(true).delay(1500, TimeUnit.MILLISECONDS).subscribe(v -> {
            MainActivity.start(this);
            finish();
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
