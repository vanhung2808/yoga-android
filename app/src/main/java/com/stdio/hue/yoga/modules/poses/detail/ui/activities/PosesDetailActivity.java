package com.stdio.hue.yoga.modules.poses.detail.ui.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.databinding.ActivityPosesDetailBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;
import com.stdio.hue.yoga.modules.poses.detail.presenters.PosesDetailPresenter;
import com.stdio.hue.yoga.shares.utils.ConvertJsonToNameEntity;
import com.stdio.hue.yoga.shares.utils.HtmlTextViewHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by TranHuuPhuc on 12/10/18.
 */
public class PosesDetailActivity extends BaseYogaActivity<PosesDetailPresenter, ActivityPosesDetailBinding> {
    private final static String EXTRA_POSES = "extra-poses";

    public static void start(Context context, Poses poses) {
        Intent starter = new Intent(context, PosesDetailActivity.class);
        starter.putExtra(EXTRA_POSES, poses);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_poses_detail;
    }

    private Poses poses;

    @SuppressLint("RxSubscribeOnError")
    @Override
    protected void init() {
        initToolbar();
        if (getIntent() != null) {
            poses = (Poses) getIntent().getSerializableExtra(EXTRA_POSES);
            disposableManager.add(getPresenter().getData(poses.getId(), poses.getAbilityId(), poses.getFocusId())
                    .doOnSubscribe(d -> loading(true))
                    .doOnError(throwable -> loading(false))
                    .doOnComplete(() -> loading(false))
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(results -> {
                        poses = (Poses) results.get(2);
                        viewDataBinding.setPosesName(poses.getNameEntity(gson).getNameLocale());
                        viewDataBinding.setPosesImage(poses.getImage());
                        HtmlTextViewHelper.showHtmlTextView(poses.getDescriptionLocale(gson).getNameLocale(), viewDataBinding.tvDescription);
                        if (poses.isFavorite()) {
                            viewDataBinding.ivFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_pose));
                        } else {
                            viewDataBinding.ivFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_unfavorite_pose));
                        }
                        viewDataBinding.setAbilityName(ConvertJsonToNameEntity.getNameEntity(gson, (String) results.get(0)).getNameLocale());
                        viewDataBinding.setFocusName(ConvertJsonToNameEntity.getNameEntity(gson, (String) results.get(1)).getNameLocale());
                        viewDataBinding.setIntensityName(ConvertJsonToNameEntity.getNameEntity(gson, poses.getDuration()).getNameLocale());
                    }));
        }
        initEvent();
    }

    private void initEvent() {
        viewDataBinding.ivFavorite.setOnClickListener(view -> {
            poses.setFavorite(!poses.isFavorite());
            getPresenter().updatePosesFavorite(poses);
            if (poses.isFavorite()) {
                viewDataBinding.ivFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_pose));
            } else {
                viewDataBinding.ivFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_unfavorite_pose));
            }
        });
    }

    private void initToolbar() {
        viewDataBinding.toolbar.setNavigationIcon(R.drawable.ic_back_white);
        viewDataBinding.toolbar.setTitle(R.string.poses);
        viewDataBinding.collapsToolbar.setTitleEnabled(false);
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.poses);
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
    protected PosesDetailPresenter createPresenter() {
        return getAppComponent().getPosesDetailComponent().getPosesDetailPresenter();
    }
}
