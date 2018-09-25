package com.stdio.hue.yoga.modules.main.ui.actions;

import com.stdio.hue.yoga.network.BannerQuery;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 7/13/18.
 */
public class MainAction {
    public static final PublishSubject<MainAction> publisher = PublishSubject.create();
    private boolean isLoading;
    private String errorMessage;
    private List<BannerQuery.Banner> banners;

    public static MainAction isLoading(boolean isLoading) {
        MainAction action = new MainAction();
        action.isLoading = isLoading;
        return action;
    }

    public static MainAction error(String mess) {
        MainAction action = new MainAction();
        action.errorMessage = mess;
        return action;
    }

    public static MainAction setBanners(List<BannerQuery.Banner> data) {
        MainAction action = new MainAction();
        action.banners = data;
        return action;
    }

    public List<BannerQuery.Banner> getBanners() {
        return banners;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public String getError() {
        return errorMessage;
    }
}
