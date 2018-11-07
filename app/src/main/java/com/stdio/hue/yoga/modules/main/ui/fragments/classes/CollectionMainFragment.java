package com.stdio.hue.yoga.modules.main.ui.fragments.classes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.databinding.FragmentMainCollectionsBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.collections.ui.activities.CollectionDetailActivity;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenter;
import com.stdio.hue.yoga.modules.main.ui.actions.CollectionsClassesMainAction;
import com.stdio.hue.yoga.modules.main.ui.adapters.CollectionsClassesMainAdapter;

import io.reactivex.subjects.PublishSubject;

import static com.stdio.hue.yoga.shares.utils.Constant.EXTRA_CATEGORY_ID;

/**
 * Created by TranHuuPhuc on 10/5/18.
 */
public class CollectionMainFragment extends BaseYogaFragment<MainPresenter, FragmentMainCollectionsBinding> implements AbsBindingAdapter.RecyclerViewClickListener {
    public static CollectionMainFragment newInstance(int categoryId) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_CATEGORY_ID, categoryId);
        CollectionMainFragment fragment = new CollectionMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_collections;
    }

    private CollectionsClassesMainAdapter adapter;

    @SuppressLint("RxSubscribeOnError")
    @Override
    protected void init(@Nullable View view) {
        PublishSubject<CollectionsClassesMainAction> collectionsClassesMainState = getAppComponent().getMainComponent().getCollectionsClassesMainState();
        if (getArguments() != null) {
            int categoryId = getArguments().getInt(EXTRA_CATEGORY_ID);
            getPresenter().getCollectionsOfACategory(categoryId, 100, 1, null);
        }
        adapter = new CollectionsClassesMainAdapter(this);
        viewDataBinding.rvCollections.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        viewDataBinding.rvCollections.setHasFixedSize(false);
        viewDataBinding.rvCollections.setAdapter(adapter);

        disposableManager.add(
                collectionsClassesMainState.map(CollectionsClassesMainAction::isLoading)
                        .subscribe(isLoading -> {
                        })
        );

        disposableManager.add(
                collectionsClassesMainState.filter(s -> s.getError() != null && !s.getError().isEmpty())
                        .map(CollectionsClassesMainAction::getError)
                        .subscribe(this::showToast)
        );

//        disposableManager.add(
//                collectionsClassesMainState.filter(c -> c.getCollections() != null)
//                        .map(CollectionsClassesMainAction::getCollections)
//                        .subscribe(adapter::updateData));
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

    @Override
    public void recyclerViewListClicked(View view, int position) {
        CollectionDetailActivity.start(getContext(), adapter.getCollection(position));
    }
}
