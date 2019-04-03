package com.stdio.hue.yoga.modules.splash.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.databinding.ActivitySplashBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;
import com.stdio.hue.yoga.modules.main.ui.activities.MainActivity;
import com.stdio.hue.yoga.modules.splash.presenter.SplashPresenter;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by hung.nguyendk on 4/29/18.
 */
public class SplashActivity extends BaseYogaActivity<SplashPresenter, ActivitySplashBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    private PublishSubject<SplashAction> splashActionPublishSubject;
    private int progressPoint = 0;

    @Override
    protected void init() {
        splashActionPublishSubject = getAppComponent().getSplashComponent().getSplashState();
        disposableManager.add(
                splashActionPublishSubject.filter(s -> s.getProgress() > 0)
                        .map(SplashAction::getProgress)
                        .subscribe(progress -> {
                            progressPoint += progress * 10;
                            viewDataBinding.setProgress(progressPoint);
                        })
        );
        setDefaultLanguage(Locale.ENGLISH);
        viewDataBinding.sbProcess.setProgressGradient(Color.rgb(10, 196, 186), Color.rgb(28, 208, 162), Color.rgb(43, 218, 142));
    }

    @Override
    protected void startScreen() {
    }

    @SuppressLint("RxSubscribeOnError")
    @Override
    protected void resumeScreen() {
        disposableManager.add(isInternetOn().subscribe(result -> {
            //Get seconds+ new data and save local has time update
            if (getPreferences(MODE_PRIVATE).getBoolean("new", false)) {
                if (result) {
                    String timeUpdate = getPreferences(MODE_PRIVATE).getString("timeupdate", "");
                    String timeCurrent = String.valueOf(System.currentTimeMillis());
                    disposableManager.add(
                            getPresenter().getAllDataAndSaveLocal(timeUpdate, "en")
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .map(resultGetData -> {
                                        getPreferences(MODE_PRIVATE).edit().putString("timeupdate", timeCurrent).apply();
                                        return resultGetData;
                                    })
                                    .subscribe(resultGetData -> {
                                        viewDataBinding.setProgress(progressPoint);
                                        MainActivity.start(this);
                                        finish();
                                    }, throwable -> showToast(throwable.getMessage())));
                } else {
                    viewDataBinding.sbProcess.setVisibility(View.GONE);
                    viewDataBinding.tvStatusDownload.setVisibility(View.GONE);
                    disposableManager.add(Observable.just(true).delay(1500, TimeUnit.MILLISECONDS).subscribe(v -> {
                        MainActivity.start(this);
                        finish();
                    }));
                }
            } else {
                //Get first data
                if (result) {
                    getPreferences(MODE_PRIVATE).edit().putBoolean("new", true).apply();
                    getPreferences(MODE_PRIVATE).edit().putString("timeupdate", String.valueOf(System.currentTimeMillis())).apply();
                    disposableManager.add(
                            getPresenter().getAllDataAndSaveLocal(null, "en")
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(resultGetData -> {
                                        viewDataBinding.setProgress(progressPoint);
                                        MainActivity.start(this);
                                        finish();
                                    }, throwable -> showToast(throwable.getMessage())));
                } else {
                    viewDataBinding.sbProcess.setVisibility(View.GONE);
                    viewDataBinding.tvStatusDownload.setVisibility(View.GONE);
                    showToast(R.string.msg_not_connect_internet);
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
