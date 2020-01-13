package com.stdio.hue.yoga.modules.newsdetail.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.databinding.ActivityNewsDetailBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;

public class NewsDetailActivity extends BaseYogaActivity<BasePresenter, ActivityNewsDetailBinding> {
    private static final String EXTRA_NEWS = "extra-news";

    public static void start(Context context, News news) {
        Intent starter = new Intent(context, NewsDetailActivity.class);
        starter.putExtra(EXTRA_NEWS, news);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void init() {
        viewDataBinding.toolbar.setNavigationIcon(R.drawable.ic_back_green);
        viewDataBinding.toolbar.setTitle("");
        viewDataBinding.toolbarTitle.setText("");
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if (getIntent() != null) {
            News news = (News) getIntent().getSerializableExtra(EXTRA_NEWS);
            viewDataBinding.setTitleNews(news.getNameEntity(gson).getNameLocale());
            viewDataBinding.setTotalFavorite(String.valueOf(news.getTotalFavorite()));
            loadWeb(news.getContentLocale(gson).getNameLocale());
        }
        initEvent();
    }

    private void initEvent() {

    }

    @Override
    protected void startScreen() {

    }

    @Override
    protected void resumeScreen() {

    }

    @Override
    protected void pauseScreen() {

    }

    @Override
    protected void destroyScreen() {

    }

    @NonNull
    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter();
    }

    private void loadWeb(String url) {
        viewDataBinding.wvNewsDetail.getSettings().setLoadsImagesAutomatically(true);
        viewDataBinding.wvNewsDetail.getSettings().setJavaScriptEnabled(true);
        viewDataBinding.wvNewsDetail.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        viewDataBinding.wvNewsDetail.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:(function(){ document.body.style.backgroundColor = '#ffffff'})();");
            }
        });
        viewDataBinding.wvNewsDetail.loadUrl(url);
    }
}
