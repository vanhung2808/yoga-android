package com.stdio.hue.yoga.modules.main.ui.fragments;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;

/**
 * Created by TranHuuPhuc on 9/19/18.
 */
public class PosesMainFragment extends BaseYogaFragment<BasePresenter, ViewDataBinding> {

    public static PosesMainFragment newInstance() {
        Bundle args = new Bundle();
        PosesMainFragment fragment = new PosesMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_poses;
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