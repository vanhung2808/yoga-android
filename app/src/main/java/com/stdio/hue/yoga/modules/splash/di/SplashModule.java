package com.stdio.hue.yoga.modules.splash.di;

import com.stdio.hue.yoga.modules.splash.presenter.SplashPresenter;
import com.stdio.hue.yoga.modules.splash.presenter.SplashPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hung.nguyendk on 4/29/18.
 */
@Module
@Singleton
public class SplashModule {
    @Provides
    public SplashPresenter providesSplashPresenter() {
        return new SplashPresenterImpl();
    }
}
