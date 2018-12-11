package com.stdio.hue.yoga.modules.video;

import android.content.Context;
import android.content.Intent;

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

    @Override
    protected void init() {
        if (getIntent() != null) {
            videoName = getIntent().getStringExtra(EXTRA_VIDEO_NAME);
            viewDataBinding.vvPlayer.setVideoURI(getExitsVideo(videoName));
            viewDataBinding.vvPlayer.start();
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
}
