package com.stdio.hue.yoga.modules.classes.searchs.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.data.models.base.BaseFilter;
import com.stdio.hue.yoga.databinding.FragmentSearchClassesResultBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.classes.searchs.presenters.SearchClassesPresenter;
import com.stdio.hue.yoga.modules.classes.searchs.ui.adapters.SearchClassesResultPagerAdapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by TranHuuPhuc on 10/20/18.
 */
public class SearchClassesResultFragment extends BaseYogaFragment<SearchClassesPresenter, FragmentSearchClassesResultBinding> {
    private static final String EXTRA_ABILITYS = "extra-abilities";
    private static final String EXTRA_FOCUS = "extra-focus";
    private static final String EXTRA_DURATIONS = "extra-durations";
    private static final String EXTRA_INTENSITIES = "extra-intensities";

    private static final String EXTRA_HAS_SELECTED_FILTER_ABILITYS = "extra-has-selected-filter-abilities";
    private static final String EXTRA_HAS_SELECTED_FILTER_FOCUS = "extra-has-selected-filter-focus";
    private static final String EXTRA_HAS_SELECTED_FILTER_DURATIONS = "extra-has-selected-filter-durations";
    private static final String EXTRA_HAS_SELECTED_FILTER_INTENSITIES = "extra-has-selected-filter-intensities";

    public static SearchClassesResultFragment newInstance(List<BaseFilter> filterAbility,
                                                          List<BaseFilter> filterDuration,
                                                          List<BaseFilter> filterFocus,
                                                          List<BaseFilter> filterIntensity,
                                                          boolean hasSelectedFilterAbility,
                                                          boolean hasSelectedFilterDuration,
                                                          boolean hasSelectedFilterFocus,
                                                          boolean hasSelectedFilterIntensity) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(EXTRA_ABILITYS, (ArrayList<? extends Parcelable>) filterAbility);
        args.putParcelableArrayList(EXTRA_FOCUS, (ArrayList<? extends Parcelable>) filterFocus);
        args.putParcelableArrayList(EXTRA_DURATIONS, (ArrayList<? extends Parcelable>) filterDuration);
        args.putParcelableArrayList(EXTRA_INTENSITIES, (ArrayList<? extends Parcelable>) filterIntensity);
        args.putBoolean(EXTRA_HAS_SELECTED_FILTER_ABILITYS, hasSelectedFilterAbility);
        args.putBoolean(EXTRA_HAS_SELECTED_FILTER_FOCUS, hasSelectedFilterFocus);
        args.putBoolean(EXTRA_HAS_SELECTED_FILTER_DURATIONS, hasSelectedFilterDuration);
        args.putBoolean(EXTRA_HAS_SELECTED_FILTER_INTENSITIES, hasSelectedFilterIntensity);
        SearchClassesResultFragment fragment = new SearchClassesResultFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_classes_result;
    }

    private SearchClassesResultPagerAdapter pagerAdapter;

    @Override
    protected void init(@Nullable View view) {
        if (getArguments() != null) {
            List<BaseFilter> filterAbility = getArguments().getParcelableArrayList(EXTRA_ABILITYS);
            List<BaseFilter> filterDuration = getArguments().getParcelableArrayList(EXTRA_DURATIONS);
            List<BaseFilter> filterFocus = getArguments().getParcelableArrayList(EXTRA_FOCUS);
            List<BaseFilter> filterIntensity = getArguments().getParcelableArrayList(EXTRA_INTENSITIES);
            boolean abilityHasSelected = getArguments().getBoolean(EXTRA_HAS_SELECTED_FILTER_ABILITYS);
            boolean focusHasSelected = getArguments().getBoolean(EXTRA_HAS_SELECTED_FILTER_FOCUS);
            boolean durationHasSelected = getArguments().getBoolean(EXTRA_HAS_SELECTED_FILTER_DURATIONS);
            boolean intensityHasSelected = getArguments().getBoolean(EXTRA_HAS_SELECTED_FILTER_INTENSITIES);
            if (abilityHasSelected) {
                filterAbility = removeFilterNotSelected(filterAbility);
            }
            if (focusHasSelected) {
                filterFocus = removeFilterNotSelected(filterFocus);
            }
            if (durationHasSelected) {
                filterDuration = removeFilterNotSelected(filterDuration);
            }
            if (intensityHasSelected) {
                filterIntensity = removeFilterNotSelected(filterIntensity);
            }
            //Show pager adapter.
            Log.e("PHUC", "ABILITY: " + filterAbility.size() + " - FOCUS: " + filterFocus.size() + " - DURATION: " + filterDuration.size() + " - INTENSITY: " + filterIntensity.size());
            pagerAdapter = new SearchClassesResultPagerAdapter(getChildFragmentManager(), filterAbility, filterDuration, filterFocus, filterIntensity);
            viewDataBinding.vpFilterResult.setAdapter(pagerAdapter);
            viewDataBinding.tlResult.setupWithViewPager(viewDataBinding.vpFilterResult);
        }
    }

    private List<BaseFilter> removeFilterNotSelected(List<BaseFilter> baseFilters) {
        Iterator<BaseFilter> iterator = baseFilters.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isChecked()) {
                iterator.remove();
            }
        }
        return baseFilters;
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
}
