package com.stdio.hue.yoga.modules.main.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.stdio.hue.yoga.modules.main.ui.fragments.ClassesMainFragment;
import com.stdio.hue.yoga.modules.main.ui.fragments.PosesMainFragment;
import com.stdio.hue.yoga.modules.main.ui.fragments.ScheduleMainFragment;
import com.stdio.hue.yoga.shares.utils.Constant;

/**
 * Created by TranHuuPhuc on 6/18/18.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Constant.TAB_HOME_CLASSES:
                return ClassesMainFragment.newInstance();
            case Constant.TAB_HOME_POSES:
                return PosesMainFragment.newInstance();
            case Constant.TAB_HOME_SCHEDULE:
            default:
                return ScheduleMainFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
