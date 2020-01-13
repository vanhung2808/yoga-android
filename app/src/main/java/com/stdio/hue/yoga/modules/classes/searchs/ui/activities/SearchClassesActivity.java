package com.stdio.hue.yoga.modules.classes.searchs.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.data.models.base.BaseFilter;
import com.stdio.hue.yoga.databinding.ActivitySearchClassesBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;
import com.stdio.hue.yoga.modules.classes.searchs.presenters.SearchClassesPresenter;
import com.stdio.hue.yoga.modules.classes.searchs.ui.SearchClassesListener;
import com.stdio.hue.yoga.modules.classes.searchs.ui.fragments.SearchClassesFilterFragment;
import com.stdio.hue.yoga.modules.classes.searchs.ui.fragments.SearchClassesResultFragment;

import java.util.List;

/**
 * Created by TranHuuPhuc on 10/19/18.
 */
public class SearchClassesActivity extends BaseYogaActivity<SearchClassesPresenter, ActivitySearchClassesBinding> implements SearchClassesListener {
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
        viewDataBinding.toolbar.setNavigationIcon(R.drawable.ic_back_green);
        viewDataBinding.toolbarTitle.setText("");
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
    protected SearchClassesPresenter createPresenter() {
        return getAppComponent().getSearchClassesComponent().getSearchClassesPresenter();
    }

    @Override
    public void onSearch(List<BaseFilter> filterAbility,
                         List<BaseFilter> filterDuration,
                         List<BaseFilter> filterFocus,
                         List<BaseFilter> filterIntensity,
                         boolean hasSelectedFilterAbility,
                         boolean hasSelectedFilterDuration,
                         boolean hasSelectedFilterFocus,
                         boolean hasSelectedFilterIntensity) {
//        Log.d("TAG_SEARCH","hasSelectedFilterAbility: "+hasSelectedFilterAbility);
//        Log.d("TAG_SEARCH","hasSelectedFilterDuration: "+hasSelectedFilterDuration);
//        Log.d("TAG_SEARCH","hasSelectedFilterFocus: "+hasSelectedFilterFocus);
//        Log.d("TAG_SEARCH","hasSelectedFilterIntensity: "+hasSelectedFilterIntensity);
        viewDataBinding.toolbarTitle.setText(R.string.result);
        replaceFragment(
                viewDataBinding.frameContent.getId(),
                SearchClassesResultFragment.newInstance(filterAbility,
                        filterDuration,
                        filterFocus,
                        filterIntensity,
                        hasSelectedFilterAbility,
                        hasSelectedFilterDuration,
                        hasSelectedFilterFocus,
                        hasSelectedFilterIntensity),
                true
        );
    }
}
