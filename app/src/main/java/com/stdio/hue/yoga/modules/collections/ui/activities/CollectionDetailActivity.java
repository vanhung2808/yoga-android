package com.stdio.hue.yoga.modules.collections.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;
import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.databinding.ActivityCollectionDetailBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;
import com.stdio.hue.yoga.modules.collections.ui.adapters.CollectionDetailPagerAdapter;
import com.stdio.hue.yoga.shares.utils.HtmlTextViewHelper;

import static com.stdio.hue.yoga.shares.utils.Constant.EXTRA_COLLECTION;

/**
 * Created by TranHuuPhuc on 10/20/18.
 */
public class CollectionDetailActivity extends BaseYogaActivity<BasePresenter, ActivityCollectionDetailBinding> {
//    private static final String EXTRA_COLLECTION = "extra-collection";

    public static void start(Context context, Collection collection) {
        Intent starter = new Intent(context, CollectionDetailActivity.class);
        starter.putExtra(EXTRA_COLLECTION, collection);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection_detail;
    }

    @Override
    protected void init() {
        viewDataBinding.toolbar.setNavigationIcon(R.drawable.ic_back_white);
        viewDataBinding.collapsToolbar.setTitleEnabled(false);
        viewDataBinding.toolbarTitle.setText(R.string.collection);
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if (getIntent() != null) {
            Collection collection = (Collection) getIntent().getSerializableExtra(EXTRA_COLLECTION);
            viewDataBinding.setCollection(collection);
            viewDataBinding.setName(collection.getNameEntity(gson).getNameLocale());
            HtmlTextViewHelper.showHtmlTextView(collection.getDescriptionLocale(new GsonBuilder().create()).getNameLocale(), viewDataBinding.tvCollectionDescription);
            viewDataBinding.vpCollection.setAdapter(new CollectionDetailPagerAdapter(getSupportFragmentManager(), collection.getId()));
            viewDataBinding.tlCollection.setupWithViewPager(viewDataBinding.vpCollection);
        }
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

}
