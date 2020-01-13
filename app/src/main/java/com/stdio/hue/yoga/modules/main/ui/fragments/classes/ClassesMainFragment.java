package com.stdio.hue.yoga.modules.main.ui.fragments.classes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.common.widgets.slider.library.SliderLayout;
import com.stdio.hue.yoga.common.widgets.slider.library.SliderTypes.BaseSliderView;
import com.stdio.hue.yoga.common.widgets.slider.library.SliderTypes.TextSliderView;
import com.stdio.hue.yoga.data.models.Banner;
import com.stdio.hue.yoga.databinding.FragmentMainClassesBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.classes.searchs.ui.activities.SearchClassesActivity;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenter;
import com.stdio.hue.yoga.modules.main.ui.actions.MainAction;
import com.stdio.hue.yoga.modules.main.ui.adapters.homeclasses.ClassesMainPagerAdapter;
import com.stdio.hue.yoga.shares.utils.SHStringHelper;
import com.stdio.hue.yoga.shares.utils.ViewUtils;

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

    @SuppressLint("RxSubscribeOnError")
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
                            for (Banner slider : banners) {
                                TextSliderView textSliderView = new TextSliderView(getContext());
                                textSliderView.description(slider.getCollection() == null || SHStringHelper.nullOrEmpty(slider.getCollection().getName()) ? "" : slider.getCollection().getNameEntity(gson).getNameLocale())
                                        .image(slider.getImage())
                                        .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                                        .setOnSliderClickListener(this);
                                textSliderView.bundle(new Bundle());
                                textSliderView.getBundle().putString("extra", slider.getImage());
                                viewDataBinding.slider.addSlider(textSliderView);
                            }
                        }));
        initEvent();
    }

    @SuppressLint("ResourceAsColor")
    private void initEvent() {

        ViewUtils.setOnDelayClick(viewDataBinding.ivSearch, v -> SearchClassesActivity.start(getContext()));
        viewDataBinding.vpClasses.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    viewDataBinding.btCollections.setTextSize(22);
                    viewDataBinding.btDownloaded.setTextSize(19);
                    viewDataBinding.btCollections.setBackgroundResource(R.drawable.background_gray_light_corner);
                    viewDataBinding.btCollections.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
                    viewDataBinding.btDownloaded.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGrayLightes));
                    viewDataBinding.btDownloaded.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
                } else {
                    viewDataBinding.btCollections.setTextSize(19);
                    viewDataBinding.btDownloaded.setTextSize(22);
                    viewDataBinding.btDownloaded.setBackgroundResource(R.drawable.background_gray_light_corner);
                    viewDataBinding.btDownloaded.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
                    viewDataBinding.btCollections.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGrayLightes));
                    viewDataBinding.btCollections.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        ViewUtils.setOnDelayClick(viewDataBinding.btCollections, v -> {
            viewDataBinding.btCollections.setTextSize(22);
            viewDataBinding.btDownloaded.setTextSize(19);
            viewDataBinding.btCollections.setBackgroundResource(R.drawable.background_gray_light_corner);
            viewDataBinding.btCollections.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
            viewDataBinding.btDownloaded.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGrayLightes));
            viewDataBinding.btDownloaded.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
            viewDataBinding.vpClasses.setCurrentItem(0);
        });

        ViewUtils.setOnDelayClick(viewDataBinding.btDownloaded, v -> {
            viewDataBinding.btCollections.setTextSize(19);
            viewDataBinding.btDownloaded.setTextSize(22);
            viewDataBinding.btDownloaded.setBackgroundResource(R.drawable.background_gray_light_corner);
            viewDataBinding.btDownloaded.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
            viewDataBinding.btCollections.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGrayLightes));
            viewDataBinding.btCollections.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
            viewDataBinding.vpClasses.setCurrentItem(1);
        });

    }

    private void initSlider() {
        viewDataBinding.slider.getPagerIndicator().setDefaultIndicatorColor(ContextCompat.getColor(getContext(), R.color.colorPrimary), ContextCompat.getColor(getContext(), R.color.colorWhiteLight));
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