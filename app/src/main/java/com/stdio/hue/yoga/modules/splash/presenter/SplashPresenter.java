package com.stdio.hue.yoga.modules.splash.presenter;

import com.stdio.hue.yoga.base.core.mvp.Presenter;

import io.reactivex.Observable;

/**
 * Created by hung.nguyendk on 4/29/18.
 */
public interface SplashPresenter extends Presenter {
    Observable<Boolean> getAllDataAndSaveLocal(Integer timeUpdate, String language);
}
