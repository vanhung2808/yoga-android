package com.stdio.hue.yoga.modules.classes.searchs.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.databinding.ActivitySearchClassesBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;
import com.stdio.hue.yoga.modules.classes.searchs.ui.SearchClassesListener;
import com.stdio.hue.yoga.modules.classes.searchs.ui.fragments.SearchClassesFilterFragment;
import com.stdio.hue.yoga.modules.classes.searchs.ui.fragments.SearchClassesResultFragment;

/**
 * Created by TranHuuPhuc on 10/19/18.
 */
public class SearchClassesActivity extends BaseYogaActivity<BasePresenter, ActivitySearchClassesBinding> implements SearchClassesListener {
    public static void start(Context context) {
        Intent starter = new Intent(context, SearchClassesActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_classes;
    }

    @Override
    protected void init() {
        viewDataBinding.toolbar.setTitle(R.string.search);
        viewDataBinding.toolbar.setNavigationIcon(R.drawable.ic_back_green);
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        replaceFragment(viewDataBinding.frameContent.getId(), SearchClassesFilterFragment.newInstance(), false);
    }

    @Override
    protected void startScreen() {

    }

    @Override
    protected void resumeScreen() {

    }

    @Override
    protected void pauseScreen() {

    }

    @Override
    protected void destroyScreen() {

    }

    @NonNull
    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter();
    }

    @Override
    public void onSearch() {
        viewDataBinding.toolbar.setTitle(R.string.result);
        replaceFragment(viewDataBinding.frameContent.getId(), SearchClassesResultFragment.newInstance(), true);
    }
}
