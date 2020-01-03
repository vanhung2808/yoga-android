package com.stdio.hue.yoga.modules.main.ui.adapters.homeclasses;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.stdio.hue.yoga.modules.main.ui.fragments.classes.CollectionsClassesMainFragment;
import com.stdio.hue.yoga.modules.main.ui.fragments.classes.CustomClassesMainFragment;
import com.stdio.hue.yoga.shares.utils.Constant;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class ClassesMainPagerAdapter extends FragmentStatePagerAdapter {
    public ClassesMainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Constant.TAB_HOME_CLASSES_COLLECTIONS:
                return CollectionsClassesMainFragment.newInstance();
            default:
                return CustomClassesMainFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
