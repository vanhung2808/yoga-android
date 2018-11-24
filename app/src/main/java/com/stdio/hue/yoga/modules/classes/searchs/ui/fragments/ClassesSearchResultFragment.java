package com.stdio.hue.yoga.modules.classes.searchs.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.data.models.base.BaseFilter;
import com.stdio.hue.yoga.databinding.FragmentClassesSearchResultBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.classes.searchs.presenters.SearchClassesPresenter;
import com.stdio.hue.yoga.modules.classes.searchs.ui.actions.SearchClassesAction;
import com.stdio.hue.yoga.modules.collections.models.FilterClasses;
import com.stdio.hue.yoga.modules.collections.ui.adapters.ClassesCollectionDetailAdapter;
import com.stdio.hue.yoga.modules.collections.ui.adapters.ClassesOfCollectionAdapter;
import com.stdio.hue.yoga.shares.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 11/24/18.
 */
public class ClassesSearchResultFragment extends BaseYogaFragment<SearchClassesPresenter, FragmentClassesSearchResultBinding> implements ClassesOfCollectionAdapter.ClassesOfCollectionAdapterListener {
    private static final String EXTRA_TYPE_FILTER = "extra-type-filter";
    private static final String EXTRA_BASE_FILTERS = "extra-base-filters";

    public static ClassesSearchResultFragment newInstance(int typeFilter, List<BaseFilter> baseFilterList) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_TYPE_FILTER, typeFilter);
        args.putParcelableArrayList(EXTRA_BASE_FILTERS, (ArrayList<? extends Parcelable>) baseFilterList);
        ClassesSearchResultFragment fragment = new ClassesSearchResultFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classes_search_result;
    }

    private int typeFilter;

    @Override
    protected void init(@Nullable View view) {
        PublishSubject<SearchClassesAction> searchClassesAction = getAppComponent().getSearchClassesComponent().getSearchClassesAction();
        if (getArguments() != null) {
            typeFilter = getArguments().getInt(EXTRA_TYPE_FILTER);
            getPresenter().getClassesResultFilter(typeFilter, getArguments().getParcelableArrayList(EXTRA_BASE_FILTERS));
        }
        disposableManager.add(
                searchClassesAction.map(SearchClassesAction::isLoading)
                        .subscribe(isLoading -> loading(isLoading))
        );

        disposableManager.add(
                searchClassesAction.filter(s -> s.getError() != null && !s.getError().isEmpty())
                        .map(SearchClassesAction::getError)
                        .subscribe(this::showToast)
        );


        if (typeFilter == Constant.TAB_ABILITY) {
            disposableManager.add(
                    searchClassesAction.filter(c -> c.getFilterAbilityClassesList() != null)
                            .map(SearchClassesAction::getFilterAbilityClassesList)
                            .subscribe(this::initAdapter));
        } else if (typeFilter == Constant.TAB_FOCUS) {
            disposableManager.add(
                    searchClassesAction.filter(c -> c.getFilterFocusClassesList() != null)
                            .map(SearchClassesAction::getFilterFocusClassesList)
                            .subscribe(this::initAdapter));
        } else if (typeFilter == Constant.TAB_INTENSITY) {
            disposableManager.add(
                    searchClassesAction.filter(c -> c.getFilterIntensityClassesList() != null)
                            .map(SearchClassesAction::getFilterIntensityClassesList)
                            .subscribe(this::initAdapter));
        } else {
            disposableManager.add(
                    searchClassesAction.filter(c -> c.getFilterDurationClassesList() != null)
                            .map(SearchClassesAction::getFilterDurationClassesList)
                            .subscribe(this::initAdapter));
        }
    }

    private void initAdapter(List<FilterClasses> filterClassesList) {
        ClassesCollectionDetailAdapter adapter = new ClassesCollectionDetailAdapter(this);
        viewDataBinding.rvClasses.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        viewDataBinding.rvClasses.setAdapter(adapter);
        adapter.updateData(filterClassesList);
    }

    @Override
    protected void screenResume() {

    }

    @Override
    protected void screenPause() {

    }

    @Override
    protected void screenStart(@Nullable Bundle saveInstanceState) {

    }

    @Override
    protected void attach(Context context) {

    }

    @NonNull
    @Override
    protected SearchClassesPresenter createPresenter() {
        return getAppComponent().getSearchClassesComponent().getSearchClassesPresenter();
    }

    @Override
    public void onItemClassesClick(Classes classes) {

    }
}
