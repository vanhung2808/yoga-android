package com.stdio.hue.yoga.modules.main.ui.fragments.poses;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.databinding.FragmentMainPosesBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.main.ui.adapters.homeposes.PosesMainPagerAdapter;

/**
 * Created by TranHuuPhuc on 9/19/18.
 */
public class PosesMainFragment extends BaseYogaFragment<BasePresenter, FragmentMainPosesBinding> {

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
        viewDataBinding.vpPoses.setAdapter(new PosesMainPagerAdapter(getChildFragmentManager()));
        initEvent();
    }

    private void initEvent() {
        viewDataBinding.vpPoses.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    viewDataBinding.btPoses.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
                    viewDataBinding.btPoses.setBackgroundResource(R.drawable.background_gray_light_corner);
                    viewDataBinding.btBlocks.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
                    viewDataBinding.btBlocks.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
                    viewDataBinding.btFavorites.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
                    viewDataBinding.btFavorites.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
                } else if (i == 1) {
                    viewDataBinding.btBlocks.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
                    viewDataBinding.btBlocks.setBackgroundResource(R.drawable.background_gray_light_corner);
                    viewDataBinding.btPoses.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
                    viewDataBinding.btPoses.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
                    viewDataBinding.btFavorites.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
                    viewDataBinding.btFavorites.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
                } else {
                    viewDataBinding.btFavorites.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
                    viewDataBinding.btFavorites.setBackgroundResource(R.drawable.background_gray_light_corner);
                    viewDataBinding.btBlocks.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
                    viewDataBinding.btBlocks.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
                    viewDataBinding.btPoses.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
                    viewDataBinding.btPoses.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        viewDataBinding.vpPoses.setAdapter(new PosesMainPagerAdapter(getChildFragmentManager()));
        viewDataBinding.btPoses.setOnClickListener(view -> {
            viewDataBinding.btPoses.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
            viewDataBinding.btPoses.setBackgroundResource(R.drawable.background_gray_light_corner);
            viewDataBinding.btBlocks.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
            viewDataBinding.btBlocks.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
            viewDataBinding.btFavorites.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
            viewDataBinding.btFavorites.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
            viewDataBinding.vpPoses.setCurrentItem(0);
        });
        viewDataBinding.btBlocks.setOnClickListener(view -> {
            viewDataBinding.btBlocks.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
            viewDataBinding.btBlocks.setBackgroundResource(R.drawable.background_gray_light_corner);
            viewDataBinding.btPoses.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
            viewDataBinding.btPoses.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
            viewDataBinding.btFavorites.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
            viewDataBinding.btFavorites.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
            viewDataBinding.vpPoses.setCurrentItem(1);
        });
        viewDataBinding.btFavorites.setOnClickListener(view -> {
            viewDataBinding.btFavorites.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
            viewDataBinding.btFavorites.setBackgroundResource(R.drawable.background_gray_light_corner);
            viewDataBinding.btBlocks.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
            viewDataBinding.btBlocks.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
            viewDataBinding.btPoses.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
            viewDataBinding.btPoses.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
            viewDataBinding.vpPoses.setCurrentItem(2);
        });
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