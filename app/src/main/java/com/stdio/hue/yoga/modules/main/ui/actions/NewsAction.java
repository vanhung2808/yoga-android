package com.stdio.hue.yoga.modules.main.ui.actions;

import com.stdio.hue.yoga.data.models.News;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by DucPham on 28/11/2018.
 */
public class NewsAction {
    public static final PublishSubject<NewsAction> publisher = PublishSubject.create();
    private boolean isLoading;
    private String errorMessage;
    private List<News> news;

    public static NewsAction isLoading(boolean isLoading) {
        NewsAction action = new NewsAction();
        action.isLoading = isLoading;
        return action;
    }

    public static NewsAction error(String mess) {
        NewsAction action = new NewsAction();
        action.errorMessage = mess;
        return action;
    }

    public static NewsAction setNews(List<News> news) {
        NewsAction action = new NewsAction();
        action.news = news;
        return action;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public String getError() {
        return errorMessage;
    }

    public List<News> getNews() {
        return news;
    }
}
