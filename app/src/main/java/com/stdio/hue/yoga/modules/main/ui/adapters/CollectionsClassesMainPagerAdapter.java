package com.stdio.hue.yoga.modules.main.ui.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.stdio.hue.yoga.data.models.Category;
import com.stdio.hue.yoga.modules.main.ui.fragments.classes.CollectionMainFragment;

import java.util.List;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class CollectionsClassesMainPagerAdapter extends FragmentStatePagerAdapter {
    private List<Category> categories;

    public CollectionsClassesMainPagerAdapter(FragmentManager fm, List<Category> categories) {
        super(fm);
        this.categories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        return CollectionMainFragment.newInstance(categories.get(position).getId());
    }

    @Override
    public int getCount() {
        return categories == null ? 0 : categories.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getName();
    }
}
