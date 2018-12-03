package com.stdio.hue.yoga.modules.main.ui.fragments.news;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.common.widgets.slider.library.SliderLayout;
import com.stdio.hue.yoga.common.widgets.slider.library.SliderTypes.BaseSliderView;
import com.stdio.hue.yoga.common.widgets.slider.library.SliderTypes.TextSliderView;
import com.stdio.hue.yoga.data.models.Banner;
import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.databinding.FragmentMainNewsBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenter;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenterImpl;
import com.stdio.hue.yoga.modules.main.ui.actions.MainAction;
import com.stdio.hue.yoga.modules.main.ui.actions.NewsAction;
import com.stdio.hue.yoga.modules.main.ui.adapters.NewsMainAdapter;
import com.stdio.hue.yoga.modules.newsdetail.ui.activity.NewsDetailActivity;
import com.stdio.hue.yoga.shares.utils.SHStringHelper;

import java.util.HashMap;
import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 10/19/18.
 */
public class NewsMainFragment extends BaseYogaFragment<MainPresenter, FragmentMainNewsBinding> implements BaseSliderView.OnSliderClickListener, AbsBindingAdapter.RecyclerViewClickListener, NewsMainAdapter.NewsMainAdapterListener {

    public static NewsMainFragment newInstance() {
        Bundle args = new Bundle();
        NewsMainFragment fragment = new NewsMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_news;
    }

    private NewsMainAdapter adapter;

    @SuppressLint("RxSubscribeOnError")
    @Override
    protected void init(@Nullable View view) {

        initSlider();
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

        PublishSubject<NewsAction> newsMainState = getAppComponent().getMainComponent().getNewsMainState();
        getPresenter().getAllNews();
        adapter = new NewsMainAdapter(this, this);
        viewDataBinding.rvMainNews.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        viewDataBinding.rvMainNews.setHasFixedSize(false);
        viewDataBinding.rvMainNews.setAdapter(adapter);

        disposableManager.add(
                newsMainState.map(NewsAction::isLoading)
                        .subscribe(isLoading -> {
                        })
        );

        disposableManager.add(
                newsMainState.filter(s -> s.getError() != null && !s.getError().isEmpty())
                        .map(NewsAction::getError)
                        .subscribe(this::showToast)
        );

        disposableManager.add(
                newsMainState.filter(c -> c.getNews() != null)
                        .map(NewsAction::getNews)
                        .subscribe(adapter::updateData)
        );

        initEvent();
    }

    private void initEvent() {

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

    }

    @Override
    public void recyclerViewListClicked(View view, int position) {
        NewsDetailActivity.start(getContext(), adapter.getNews(position));
    }

    @Override
    public void onClickFavorite(int position) {
        Toast.makeText(getContext(), "On Click " + position, Toast.LENGTH_SHORT).show();
    }
}
