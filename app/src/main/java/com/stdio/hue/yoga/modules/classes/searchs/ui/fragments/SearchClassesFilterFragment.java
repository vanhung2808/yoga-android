package com.stdio.hue.yoga.modules.classes.searchs.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.databinding.FragmentSearchClassesFilterBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.classes.searchs.ui.SearchClassesListener;
import com.stdio.hue.yoga.modules.classes.searchs.ui.activities.SearchClassesActivity;
import com.stdio.hue.yoga.modules.classes.searchs.ui.adapters.SearchClassesFilterAdapter;

/**
 * Created by TranHuuPhuc on 10/20/18.
 */
public class SearchClassesFilterFragment extends BaseYogaFragment<BasePresenter, FragmentSearchClassesFilterBinding> {
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
        adapter = new SearchClassesFilterAdapter();
        viewDataBinding.rvFilter.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        viewDataBinding.rvFilter.setAdapter(adapter);
        viewDataBinding.tvClearAll.setOnClickListener(view1 -> adapter.clearAllSelector());
        viewDataBinding.btSearch.setOnClickListener(view1 -> {
            listener.onSearch();
        });
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
    protected BasePresenter createPresenter() {
        return new BasePresenter();
    }
}