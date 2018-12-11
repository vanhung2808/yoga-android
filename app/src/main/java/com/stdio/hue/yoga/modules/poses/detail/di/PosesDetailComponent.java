package com.stdio.hue.yoga.modules.poses.detail.di;

import com.stdio.hue.yoga.modules.poses.detail.presenters.PosesDetailPresenter;

import dagger.Subcomponent;

/**
 * Created by TranHuuPhuc on 12/10/18.
 */
@Subcomponent(modules = PosesDetailModule.class)
public interface PosesDetailComponent {
    PosesDetailPresenter getPosesDetailPresenter();
}
