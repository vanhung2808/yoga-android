package com.stdio.hue.yoga.modules.classes.searchs.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.databinding.FragmentSearchClassesFilterBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.classes.searchs.presenters.SearchClassesPresenter;
import com.stdio.hue.yoga.modules.classes.searchs.ui.SearchClassesListener;
import com.stdio.hue.yoga.modules.classes.searchs.ui.actions.SearchClassesAction;
import com.stdio.hue.yoga.modules.classes.searchs.ui.activities.SearchClassesActivity;
import com.stdio.hue.yoga.modules.classes.searchs.ui.adapters.SearchClassesFilterAdapter;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 10/20/18.
 */
public class SearchClassesFilterFragment extends BaseYogaFragment<SearchClassesPresenter, FragmentSearchClassesFilterBinding> implements SearchClassesFilterAdapter.SearchClassesFilterAdapterListener {
    public static SearchClassesFilterFragment newInstance() {
        Bundle args = new Bundle();
        SearchClassesFilterFragment fragment = new SearchClassesFilterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_classes_filter;
    }

    private SearchClassesFilterAdapter adapter;
    private SearchClassesListener listener;

    @Override
    protected void init(@Nullable View view) {
        PublishSubject<SearchClassesAction> searchClassesAction = getAppComponent().getSearchClassesComponent().getSearchClassesAction();
        getPresenter().getFilterData();
        adapter = new SearchClassesFilterAdapter(this);
        viewDataBinding.rvFilter.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        viewDataBinding.rvFilter.setAdapter(adapter);
        disposableManager.add(
                searchClassesAction.map(SearchClassesAction::isLoading)
                        .subscribe(isLoading -> {
                        })
        );

        disposableManager.add(
                searchClassesAction.filter(s -> s.getError() != null && !s.getError().isEmpty())
                        .map(SearchClassesAction::getError)
                        .subscribe(this::showToast)
        );

        disposableManager.add(
                searchClassesAction.filter(c -> c.getFilter() != null)
                        .map(SearchClassesAction::getFilter)
                        .subscribe(filters -> adapter.updateData(filters)));
        viewDataBinding.tvClearAll.setOnClickListener(view1 -> adapter.clearAllSelector());
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
        if (context instanceof SearchClassesActivity) {
            listener = (SearchClassesListener) context;
        }
    }

    @NonNull
    @Override
    protected SearchClassesPresenter createPresenter() {
        return getAppComponent().getSearchClassesComponent().getSearchClassesPresenter();
    }

    @Override
    public void onSearchClick() {
        listener.onSearch(
                adapter.getFilterAbility(),
                adapter.getFilterDuration(),
                adapter.getFilterFocus(),
                adapter.getFilterIntensity(),
                adapter.getHasSelectedFilterAbility(),
                adapter.getHasSelectedFilterDuration(),
                adapter.getHasSelectedFilterFocus(),
                adapter.getHasSelectedFilterIntensity()
        );
    }
}