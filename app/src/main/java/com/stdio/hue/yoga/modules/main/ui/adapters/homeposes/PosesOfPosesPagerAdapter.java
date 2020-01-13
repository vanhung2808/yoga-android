package com.stdio.hue.yoga.modules.main.ui.adapters.homeposes;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.google.gson.GsonBuilder;
import com.stdio.hue.yoga.data.models.PosesType;
import com.stdio.hue.yoga.modules.main.ui.fragments.poses.PosesOfPosesMainFragment;
import com.stdio.hue.yoga.shares.utils.Constant;

import java.util.List;

/**
 * Created by dungbeo on 1/12/2020.
 */
public class PosesOfPosesPagerAdapter extends FragmentStatePagerAdapter {
    private List<PosesType> posesTypes;

    public PosesOfPosesPagerAdapter(FragmentManager fm, List<PosesType> posesTypes) {
        super(fm);
        this.posesTypes = posesTypes;
    }

    @Override
    public Fragment getItem(int position) {
//        return PosesOfPosesMainFragment.newInstance(posesTypes.get(position).getId());
        return PosesOfPosesMainFragment.newInstance();
    }

    @Override
    public int getCount() {
        return posesTypes == null ? 0 : posesTypes.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return posesTypes.get(position).getNameEntity(new GsonBuilder().create()).getNameLocale();
    }

//    private int classId;
//
//    public PosesOfPosesPagerAdapter(FragmentManager fm, int classId) {
//        super(fm);
//        this.classId = classId;
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case Constant.TAB_POSES_NAME:
//                return PosesOfPosesMainFragment.newInstance(Constant.TAB_POSES_NAME,classId);
//            case Constant.TAB_POSES_TYPE:
//                return PosesOfPosesMainFragment.newInstance(Constant.TAB_POSES_TYPE,classId);
//            case Constant.TAB_POSES_ABILITY:
//                return PosesOfPosesMainFragment.newInstance(Constant.TAB_POSES_ABILITY,classId);
//            default:
//                return PosesOfPosesMainFragment.newInstance(Constant.TAB_POSES_FOCUS,classId);
//        }
//
//    }
//
//    @Override
//    public int getCount() {
//        return 4;
//    }
//
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position) {
//            case Constant.TAB_POSES_NAME:
//                return "Name";
//            case Constant.TAB_POSES_TYPE:
//                return "Type";
//            case Constant.TAB_POSES_ABILITY:
//                return "Ability";
//            default:
//                return "Focus";
//        }
//    }
}
