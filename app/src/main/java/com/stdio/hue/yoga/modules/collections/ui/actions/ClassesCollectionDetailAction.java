package com.stdio.hue.yoga.modules.collections.ui.actions;

import com.stdio.hue.yoga.modules.collections.models.FilterClasses;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 11/23/18.
 */
public class ClassesCollectionDetailAction {
    public static final PublishSubject<ClassesCollectionDetailAction> publisher = PublishSubject.create();
    private boolean isLoading;
    private String errorMessage;
    private List<FilterClasses> filterDurationClassesList, filterFocusClassesList, filterAbilityClassesList, filterIntensityClassesList;

    public static ClassesCollectionDetailAction isLoading(boolean isLoading) {
        ClassesCollectionDetailAction action = new ClassesCollectionDetailAction();
        action.isLoading = isLoading;
        return action;
    }

    public static ClassesCollectionDetailAction error(String mess) {
        ClassesCollectionDetailAction action = new ClassesCollectionDetailAction();
        action.errorMessage = mess;
        return action;
    }

    public static ClassesCollectionDetailAction setFilterDurationClasses(List<FilterClasses> data) {
        ClassesCollectionDetailAction action = new ClassesCollectionDetailAction();
        action.filterDurationClassesList = data;
        return action;
    }

    public static ClassesCollectionDetailAction setFilterAbilityClasses(List<FilterClasses> data) {
        ClassesCollectionDetailAction action = new ClassesCollectionDetailAction();
        action.filterAbilityClassesList = data;
        return action;
    }

    public static ClassesCollectionDetailAction setFilterIntensityClasses(List<FilterClasses> data) {
        ClassesCollectionDetailAction action = new ClassesCollectionDetailAction();
        action.filterIntensityClassesList = data;
        return action;
    }

    public static ClassesCollectionDetailAction setFilterFocusClasses(List<FilterClasses> data) {
        ClassesCollectionDetailAction action = new ClassesCollectionDetailAction();
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

    public boolean isLoading() {
        return isLoading;
    }

    public String getError() {
        return errorMessage;
    }
}
