package com.stdio.hue.yoga.modules.main.ui.actions;

import com.stdio.hue.yoga.data.models.Category;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 10/5/18.
 */
public class CollectionsClassesMainAction {
    public static final PublishSubject<CollectionsClassesMainAction> publisher = PublishSubject.create();
    private boolean isLoading;
    private String errorMessage;
    private List<Category> categories;

    public static CollectionsClassesMainAction isLoading(boolean isLoading) {
        CollectionsClassesMainAction action = new CollectionsClassesMainAction();
        action.isLoading = isLoading;
        return action;
    }

    public static CollectionsClassesMainAction error(String mess) {
        CollectionsClassesMainAction action = new CollectionsClassesMainAction();
        action.errorMessage = mess;
        return action;
    }

    public static CollectionsClassesMainAction setCategories(List<Category> categories) {
        CollectionsClassesMainAction action = new CollectionsClassesMainAction();
        action.categories = categories;
        return action;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public String getError() {
        return errorMessage;
    }

    public List<Category> getCategories() {
        return categories;
    }
}