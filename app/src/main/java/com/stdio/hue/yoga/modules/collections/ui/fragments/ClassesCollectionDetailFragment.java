package com.stdio.hue.yoga.modules.collections.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.databinding.FragmentClassesCollectionDetailBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.collections.presenter.ClassesCollectionDetailPresenter;
import com.stdio.hue.yoga.modules.collections.ui.actions.ClassesCollectionDetailAction;
import com.stdio.hue.yoga.modules.collections.ui.adapters.ClassesCollectionDetailAdapter;
import com.stdio.hue.yoga.modules.collections.ui.adapters.ClassesOfCollectionAdapter;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 11/23/18.
 */
public class ClassesCollectionDetailFragment extends BaseYogaFragment<ClassesCollectionDetailPresenter, FragmentClassesCollectionDetailBinding> implements ClassesOfCollectionAdapter.ClassesOfCollectionAdapterListener {
    private static final String EXTRA_TAB_STYLE = "extra-tab-style";
    private static final String EXTRA_COLLECTION_IDEXTRA_COLLECTION_ID = "extra-collection-id";

    public static ClassesCollectionDetailFragment newInstance(int tabStyle, int collectionId) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_TAB_STYLE, tabStyle);
        args.putInt(EXTRA_COLLECTION_IDEXTRA_COLLECTION_ID, collectionId);
        ClassesCollectionDetailFragment fragment = new ClassesCollectionDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classes_collection_detail;
    }

    private ClassesCollectionDetailAdapter adapter;

    @Override
    protected void init(@Nullable View view) {
        initAdapter();
        if (getArguments() != null) {
            getPresenter().getFiltersType(getArguments().getInt(EXTRA_TAB_STYLE), getArguments().getInt(EXTRA_COLLECTION_IDEXTRA_COLLECTION_ID));
        }
        PublishSubject<ClassesCollectionDetailAction> classesCollectionDetailAction = getAppComponent().getCollectionDetailComponent().getClassesCollectionDetailAction();
        disposableManager.add(
                classesCollectionDetailAction.map(ClassesCollectionDetailAction::isLoading)
                        .subscribe(isLoading -> {
                        })
        );

        disposableManager.add(
                classesCollectionDetailAction.filter(s -> s.getError() != null && !s.getError().isEmpty())
                        .map(ClassesCollectionDetailAction::getError)
                        .subscribe(this::showToast)
        );

        disposableManager.add(
                classesCollectionDetailAction.filter(c -> c.getFilterClassesList() != null)
                        .map(ClassesCollectionDetailAction::getFilterClassesList)
                        .subscribe(filterClasses -> adapter.updateData(filterClasses)));
    }

    private void initAdapter() {
        adapter = new ClassesCollectionDetailAdapter(this);
        viewDataBinding.rvClasses.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        viewDataBinding.rvClasses.setAdapter(adapter);
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
    protected ClassesCollectionDetailPresenter createPresenter() {
        return getAppComponent().getCollectionDetailComponent().getClassesCollectionDetailPresenter();
    }

    @Override
    public void onItemClassesClick(Classes classes) {
        //Todo show Classes Detail Screen
    }
}
