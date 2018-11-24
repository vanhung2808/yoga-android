package com.stdio.hue.yoga.modules.collections.ui.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.stdio.hue.yoga.modules.collections.ui.fragments.ClassesCollectionDetailFragment;
import com.stdio.hue.yoga.shares.utils.Constant;

/**
 * Created by TranHuuPhuc on 11/23/18.
 */
public class CollectionDetailPagerAdapter extends FragmentStatePagerAdapter {
    private int collectionId;

    public CollectionDetailPagerAdapter(FragmentManager fm, int collectionId) {
        super(fm);
        this.collectionId = collectionId;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Constant.TAB_ABILITY:
                return ClassesCollectionDetailFragment.newInstance(Constant.TAB_ABILITY,collectionId);
            case Constant.TAB_FOCUS:
                return ClassesCollectionDetailFragment.newInstance(Constant.TAB_FOCUS,collectionId);
            case Constant.TAB_DURATION:
            default:
                return ClassesCollectionDetailFragment.newInstance(Constant.TAB_DURATION,collectionId);
        }
    }

    @Override
    public int getCount() {
        return 3;
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
            default:
                return "Duration";
        }
    }
}
