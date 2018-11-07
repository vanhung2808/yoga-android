package com.stdio.hue.yoga.modules.splash.di;

import com.stdio.hue.yoga.modules.splash.presenter.SplashPresenter;

import dagger.Subcomponent;

/**
 * Created by hung.nguyendk on 4/29/18.
 */
@Subcomponent(modules = SplashModule.class)
public interface SplashComponent {
    SplashPresenter getSplashPresenter();
}
