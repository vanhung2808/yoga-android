package com.stdio.hue.yoga.modules.main.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.common.widgets.slider.library.SliderLayout;
import com.stdio.hue.yoga.common.widgets.slider.library.SliderTypes.BaseSliderView;
import com.stdio.hue.yoga.common.widgets.slider.library.SliderTypes.TextSliderView;
import com.stdio.hue.yoga.databinding.FragmentMainClassesBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenter;
import com.stdio.hue.yoga.modules.main.ui.actions.MainAction;
import com.stdio.hue.yoga.modules.main.ui.adapters.ClassesMainPagerAdapter;
import com.stdio.hue.yoga.network.BannerQuery;
import com.stdio.hue.yoga.shares.utils.SHStringHelper;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 9/19/18.
 */
public class ClassesMainFragment extends BaseYogaFragment<MainPresenter, FragmentMainClassesBinding> implements BaseSliderView.OnSliderClickListener {

    public static ClassesMainFragment newInstance() {
        Bundle args = new Bundle();
        ClassesMainFragment fragment = new ClassesMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_classes;
    }

    @Override
    protected void init(@Nullable View view) {
        initSlider();
        viewDataBinding.vpClasses.setAdapter(new ClassesMainPagerAdapter(getChildFragmentManager()));
        PublishSubject<MainAction> mainState = getAppComponent().getMainComponent().getMainState();
        getPresenter().getBanners();
        disposableManager.add(
                mainState.map(MainAction::isLoading)
                        .subscribe(isLoading -> {
                        })
        );

        disposableManager.add(
                mainState.filter(s -> s.getError() != null && !s.getError().isEmpty())
                        .map(MainAction::getError)
                        .subscribe(this::showToast)
        );

        disposableManager.add(
                mainState.filter(c -> c.getBanners() != null)
                        .map(MainAction::getBanners)
                        .subscribe(banners -> {
                            viewDataBinding.slider.removeAllSliders();
                            for (BannerQuery.Banner slider : banners) {
                                TextSliderView textSliderView = new TextSliderView(getContext());
                                textSliderView
                                        .description(slider.collection() == null || SHStringHelper.nullOrEmpty(slider.collection().name()) ? "" : slider.collection().name())
                                        .image(slider.image())
                                        .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                                        .setOnSliderClickListener(this);
                                textSliderView.bundle(new Bundle());
                                textSliderView.getBundle().putString("extra", slider.image());
                                viewDataBinding.slider.addSlider(textSliderView);
                            }
                        }));

    }

    private void initSlider() {
        viewDataBinding.slider.getPagerIndicator().setDefaultIndicatorColor(ContextCompat.getColor(getContext(), R.color.colorPrimary), ContextCompat.getColor(getContext(), R.color.colorWhite));
        viewDataBinding.slider.setPresetTransformer(SliderLayout.Transformer.Default);
        viewDataBinding.slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
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
    protected MainPresenter createPresenter() {
        return getAppComponent().getMainComponent().getMainPresenter();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        //Todo open webview link slider
    }
}