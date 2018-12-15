package com.stdio.hue.yoga.modules.video.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.content.ContextCompat;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.BaseDataBindingActivity;
import com.stdio.hue.yoga.databinding.ActivityVideoBinding;

/**
 * Created by TranHuuPhuc on 12/7/18.
 */

public class VideoActivity extends BaseDataBindingActivity<ActivityVideoBinding> {
    private final static String EXTRA_VIDEO_NAME = "extra-video-name";

    public static void start(Context context, String videoName) {
        Intent starter = new Intent(context, VideoActivity.class);
        starter.putExtra(EXTRA_VIDEO_NAME, videoName);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video;
    }

    private String videoName;
    private SimpleExoPlayer player;
    private float currentVolume;
    private boolean isLand;

    @Override
    protected void init() {
        isLand = false;
        if (getIntent() != null) {
            videoName = getIntent().getStringExtra(EXTRA_VIDEO_NAME);
            player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());
            viewDataBinding.pvVideo.setPlayer(player);
            viewDataBinding.pvVideo.setFastForwardIncrementMs(15000);
            viewDataBinding.pvVideo.setRewindIncrementMs(15000);
            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "yoga-android"));
            MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(getExitsVideo(videoName));
            player.prepare(mediaSource);
            player.setPlayWhenReady(true);

            currentVolume = player.getVolume();
            viewDataBinding.flVolumn.setOnClickListener(v -> {
                if (player.getVolume() != 0) {
                    player.setVolume(0f);
                    viewDataBinding.ivVolumn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_volume_off));
                } else {
                    viewDataBinding.ivVolumn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_volume_on));
                    player.setVolume(currentVolume);
                }
            });

            viewDataBinding.ivZoom.setOnClickListener(v -> {
                if (isLand) {
                    isLand = false;
                    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else {
                    isLand = true;
                    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            });

            viewDataBinding.ivClose.setOnClickListener(view -> finish());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewDataBinding.pvVideo.setPlayer(null);
        player.release();
        player = null;
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
}
