package com.stdio.hue.yoga.modules.main.ui.actions;

import com.stdio.hue.yoga.network.GetAllCategoryQuery;
import com.stdio.hue.yoga.network.GetCollectionsOfACategoryQuery;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 10/5/18.
 */
public class CollectionsClassesMainAction {
    public static final PublishSubject<CollectionsClassesMainAction> publisher = PublishSubject.create();
    private boolean isLoading;
    private String errorMessage;
    private List<GetAllCategoryQuery.Category> categories;
    private List<GetCollectionsOfACategoryQuery.Datum> collections;

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

    public static CollectionsClassesMainAction setCategories(List<GetAllCategoryQuery.Category> categories) {
        CollectionsClassesMainAction action = new CollectionsClassesMainAction();
        action.categories = categories;
        return action;
    }

    public static CollectionsClassesMainAction setCollections(List<GetCollectionsOfACategoryQuery.Datum> collections) {
        CollectionsClassesMainAction action = new CollectionsClassesMainAction();
        action.collections = collections;
        return action;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public String getError() {
        return errorMessage;
    }

    public List<GetAllCategoryQuery.Category> getCategories() {
        return categories;
    }

    public List<GetCollectionsOfACategoryQuery.Datum> getCollections() {
        return collections;
    }
}