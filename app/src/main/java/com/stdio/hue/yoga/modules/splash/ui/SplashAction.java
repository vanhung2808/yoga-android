package com.stdio.hue.yoga.modules.splash.ui;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 4/3/19.
 */
public class SplashAction {
    public static final PublishSubject<SplashAction> publisher = PublishSubject.create();
    private int progress;

    public static SplashAction setProgess(int progress) {
        SplashAction action = new SplashAction();
        action.progress += progress;
        return action;
    }

    public int getProgress() {
        return progress;
    }
}
