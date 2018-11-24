package com.stdio.hue.yoga.modules.classes.searchs.ui.actions;

import com.stdio.hue.yoga.modules.collections.models.FilterClasses;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 11/24/18.
 */
public class SearchClassesAction {
    public static final PublishSubject<SearchClassesAction> publisher = PublishSubject.create();
    private boolean isLoading;
    private String errorMessage;
    private List<FilterClasses> filterDurationClassesList, filterFocusClassesList, filterAbilityClassesList, filterIntensityClassesList;
    private List<Object> filter;

    public static SearchClassesAction isLoading(boolean isLoading) {
        SearchClassesAction action = new SearchClassesAction();
        action.isLoading = isLoading;
        return action;
    }

    public static SearchClassesAction error(String mess) {
        SearchClassesAction action = new SearchClassesAction();
        action.errorMessage = mess;
        return action;
    }

    public static SearchClassesAction setDataFilter(List<Object> filter) {
        SearchClassesAction action = new SearchClassesAction();
        action.filter = filter;
        return action;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public String getError() {
        return errorMessage;
    }

    public static SearchClassesAction setFilterDurationClasses(List<FilterClasses> data) {
        SearchClassesAction action = new SearchClassesAction();
        action.filterDurationClassesList = data;
        return action;
    }

    public static SearchClassesAction setFilterAbilityClasses(List<FilterClasses> data) {
        SearchClassesAction action = new SearchClassesAction();
        action.filterAbilityClassesList = data;
        return action;
    }

    public static SearchClassesAction setFilterIntensityClasses(List<FilterClasses> data) {
        SearchClassesAction action = new SearchClassesAction();
        action.filterIntensityClassesList = data;
        return action;
    }

    public static SearchClassesAction setFilterFocusClasses(List<FilterClasses> data) {
        SearchClassesAction action = new SearchClassesAction();
        action.filterFocusClassesList = data;
        return action;
    }

    public List<FilterClasses> getFilterAbilityClassesList() {
        return filterAbilityClassesList;
    }

    public List<FilterClasses> getFilterDurationClassesList() {
        return filterDurationClassesList;
    }

    public List<FilterClasses> getFilterFocusClassesList() {
        return filterFocusClassesList;
    }

    public List<FilterClasses> getFilterIntensityClassesList() {
        return filterIntensityClassesList;
    }

    public List<Object> getFilter() {
        return filter;
    }
}