package com.stdio.hue.yoga.modules.main.ui.fragments.classes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.databinding.FragmentMainClassesCollectionsBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenter;
import com.stdio.hue.yoga.modules.main.ui.actions.CollectionsClassesMainAction;
import com.stdio.hue.yoga.modules.main.ui.adapters.CollectionsClassesMainPagerAdapter;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class CollectionsClassesMainFragment extends BaseYogaFragment<MainPresenter, FragmentMainClassesCollectionsBinding> {

    public static CollectionsClassesMainFragment newInstance() {
        Bundle args = new Bundle();
        CollectionsClassesMainFragment fragment = new CollectionsClassesMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_classes_collections;
    }

    @SuppressLint("RxSubscribeOnError")
    @Override
    protected void init(@Nullable View view) {
        PublishSubject<CollectionsClassesMainAction> mainState = getAppComponent().getMainComponent().getCollectionsClassesMainState();
        getPresenter().getAllCategories();
        viewDataBinding.tblCollections.setupWithViewPager(viewDataBinding.vpCollections);
        disposableManager.add(
                mainState.map(CollectionsClassesMainAction::isLoading)
                        .subscribe(isLoading -> {
                        })
        );

        disposableManager.add(
                mainState.filter(s -> s.getError() != null && !s.getError().isEmpty())
                        .map(CollectionsClassesMainAction::getError)
                        .subscribe(this::showToast)
        );

        disposableManager.add(
                mainState.filter(c -> c.getCategories() != null)
                        .map(CollectionsClassesMainAction::getCategories)
                        .subscribe(categories -> viewDataBinding.vpCollections.setAdapter(new CollectionsClassesMainPagerAdapter(getChildFragmentManager(), categories))));
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
    protected MainPresenter createPresenter() {
        return getAppComponent().getMainComponent().getMainPresenter();
    }
}
