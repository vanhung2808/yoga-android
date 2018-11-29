package com.stdio.hue.yoga.modules.main.ui.fragments.poses;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.databinding.FragmentMainPosesOfPoseBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;

/**
 * Created by TranHuuPhuc on 11/29/18.
 */
public class PosesOfPosesMainFragment extends BaseYogaFragment<BasePresenter, FragmentMainPosesOfPoseBinding> {
    public static PosesOfPosesMainFragment newInstance() {
        Bundle args = new Bundle();
        PosesOfPosesMainFragment fragment = new PosesOfPosesMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_poses_of_pose;
    }

    @Override
    protected void init(@Nullable View view) {

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
    protected BasePresenter createPresenter() {
        return new BasePresenter();
    }
}
