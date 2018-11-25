package com.stdio.hue.yoga.modules.splash.ui;

import android.annotation.SuppressLint;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;
import com.stdio.hue.yoga.modules.main.ui.activities.MainActivity;
import com.stdio.hue.yoga.modules.splash.presenter.SplashPresenter;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

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
        setDefaultLanguage(Locale.ENGLISH);
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
//                    int timeUpdate = getPreferences(MODE_PRIVATE).getInt("timeupdate", 0);
//                    long timeCurrent = System.currentTimeMillis();
//                    disposableManager.add(
//                            getPresenter().getAllDataAndSaveLocal(timeUpdate, "en")
//                                    .observeOn(AndroidSchedulers.mainThread())
//                                    .doOnSubscribe(d -> loading(true))
//                                    .doOnError(throwable -> loading(false))
//                                    .doOnComplete(() -> loading(false))
//                                    .subscribe(resultGetData -> {
//                                        getPreferences(MODE_PRIVATE).edit().putInt("timeupdate", (int) timeCurrent).apply();
//                                        MainActivity.start(this);
//                                        finish();
//                                    }, throwable -> showToast(throwable.getMessage())));
                } else {
                    disposableManager.add(Observable.just(true).delay(1500, TimeUnit.MILLISECONDS).subscribe(v -> {
                        MainActivity.start(this);
                        finish();
                    }));
                }
            } else {
                if (result) {
                    getPreferences(MODE_PRIVATE).edit().putBoolean("new", true).apply();
                    getPreferences(MODE_PRIVATE).edit().putInt("timeupdate", (int) System.currentTimeMillis()).apply();
                    disposableManager.add(
                            getPresenter().getAllDataAndSaveLocal(null, "en")
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .doOnSubscribe(d -> loading(true))
                                    .doOnError(throwable -> loading(false))
                                    .doOnComplete(() -> loading(false))
                                    .subscribe(resultGetData -> {
                                        MainActivity.start(this);
                                        finish();
                                    }, throwable -> showToast(throwable.getMessage())));
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
