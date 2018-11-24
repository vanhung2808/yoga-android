package com.stdio.hue.yoga.modules.classes.searchs.ui.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.stdio.hue.yoga.data.models.base.BaseFilter;
import com.stdio.hue.yoga.modules.classes.searchs.ui.fragments.ClassesSearchResultFragment;
import com.stdio.hue.yoga.shares.utils.Constant;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/24/18.
 */
public class SearchClassesResultPagerAdapter extends FragmentStatePagerAdapter {
    private List<BaseFilter> filterAbility;
    private List<BaseFilter> filterDuration;
    private List<BaseFilter> filterFocus;
    private List<BaseFilter> filterIntensity;

    public SearchClassesResultPagerAdapter(FragmentManager fm, List<BaseFilter> filterAbility, List<BaseFilter> filterDuration, List<BaseFilter> filterFocus, List<BaseFilter> filterIntensity) {
        super(fm);
        this.filterAbility = filterAbility;
        this.filterDuration = filterDuration;
        this.filterFocus = filterFocus;
        this.filterIntensity = filterIntensity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Constant.TAB_ABILITY:
                return ClassesSearchResultFragment.newInstance(Constant.TAB_ABILITY, filterAbility);
            case Constant.TAB_FOCUS:
                return ClassesSearchResultFragment.newInstance(Constant.TAB_FOCUS, filterFocus);
            case Constant.TAB_DURATION:
                return ClassesSearchResultFragment.newInstance(Constant.TAB_DURATION, filterDuration);
            case Constant.TAB_INTENSITY:
            default:
                return ClassesSearchResultFragment.newInstance(Constant.TAB_INTENSITY, filterIntensity);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case Constant.TAB_ABILITY:
                return "Ability";
            case Constant.TAB_FOCUS:
                return "Focus";
            case Constant.TAB_DURATION:
                return "Duration";
            case Constant.TAB_INTENSITY:
            default:
                return "Intensity";
        }
    }
}