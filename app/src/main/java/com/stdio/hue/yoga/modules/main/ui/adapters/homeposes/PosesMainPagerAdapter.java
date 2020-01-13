package com.stdio.hue.yoga.modules.main.ui.adapters.homeposes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.stdio.hue.yoga.modules.main.ui.fragments.poses.BlocksOfPosesMainFragment;
import com.stdio.hue.yoga.modules.main.ui.fragments.poses.FavoritesOfPosesMainFragment;
import com.stdio.hue.yoga.modules.main.ui.fragments.poses.PosesOfPosesMainFragment;
import com.stdio.hue.yoga.shares.utils.Constant;

/**
 * Created by TranHuuPhuc on 11/29/18.
 */
public class PosesMainPagerAdapter extends FragmentStatePagerAdapter {

    public PosesMainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Constant.TAB_HOME_POSES_POSES:
                return PosesOfPosesMainFragment.newInstance();
            case Constant.TAB_HOME_POSES_BLOCK:
                return BlocksOfPosesMainFragment.newInstance();
            case Constant.TAB_HOME_POSES_FAVORITES:
            default:
                return FavoritesOfPosesMainFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

