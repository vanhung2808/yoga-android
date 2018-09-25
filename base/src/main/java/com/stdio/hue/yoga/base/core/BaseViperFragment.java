package com.stdio.hue.yoga.base.core;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.stdio.hue.yoga.base.core.mvp.Presenter;
import com.stdio.hue.yoga.base.core.mvp.PresenterDelegate;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/**
 * Created by TranHuuPhuc on 7/6/18.
 */
public abstract class BaseViperFragment<P extends Presenter> extends BaseFragment implements Presenter.View {

    protected abstract @NonNull
    P createPresenter();

    private P presenter;

    protected P getPresenter() {
        return presenter;
    }

    private PresenterDelegate presenterDelegate;
    protected CompositeDisposable disposableManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        disposableManager = new CompositeDisposable();
        presenterDelegate = new PresenterDelegate(presenter = createPresenter());
        presenterDelegate.attach(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenterDelegate.init();
        RxJavaPlugins.setErrorHandler(Throwable::printStackTrace);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenterDelegate.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenterDelegate.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposableManager.clear();
        presenterDelegate.detach();
        presenterDelegate.destroy();
    }

}
