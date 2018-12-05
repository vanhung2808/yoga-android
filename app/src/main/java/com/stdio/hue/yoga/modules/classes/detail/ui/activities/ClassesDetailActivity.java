package com.stdio.hue.yoga.modules.classes.detail.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.databinding.ActivityClassesDetailBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;
import com.stdio.hue.yoga.modules.classes.detail.presenters.ClassesDetailPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;

import static com.stdio.hue.yoga.shares.utils.Constant.EXTRA_CLASSES;

/**
 * Created by TranHuuPhuc on 12/4/18.
 */
public class ClassesDetailActivity extends BaseYogaActivity<ClassesDetailPresenter, ActivityClassesDetailBinding> {
    public static void start(Context context, Classes classes) {
        Intent starter = new Intent(context, ClassesDetailActivity.class);
        starter.putExtra(EXTRA_CLASSES, classes);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_classes_detail;
    }

    private Classes classes;

    @Override
    protected void init() {
        initToolbar();
        if (getIntent() != null) {
            classes = (Classes) getIntent().getSerializableExtra(EXTRA_CLASSES);
            viewDataBinding.setClassesName(classes.getNameEntity(gson).getNameLocale());
            viewDataBinding.setClassesImage(classes.getImage());
            disposableManager.add(getPresenter().getData(classes.getId(), classes.getAbilityId(), classes.getIntensityId(), classes.getFocusId())
                    .doOnSubscribe(d -> loading(true))
                    .doOnError(throwable -> loading(false))
                    .doOnComplete(() -> loading(false))
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(results -> {
                        viewDataBinding.setAbilityName((String) results.get(0));
                        viewDataBinding.setIntensityName((String) results.get(1));
                        viewDataBinding.setFocusName((String) results.get(2));
                    }));
        }
    }

    private void initToolbar() {
        viewDataBinding.toolbar.setNavigationIcon(R.drawable.ic_back_white);
        viewDataBinding.toolbar.setTitle(R.string.classes);
        viewDataBinding.collapsToolbar.setTitleEnabled(false);
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.classes);
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
    protected ClassesDetailPresenter createPresenter() {
        return getAppComponent().getClassesDetailComponent().getClassesDetailPresenter();
    }
}
