package com.stdio.hue.yoga.modules.classes.detail.di;

import com.stdio.hue.yoga.modules.classes.detail.presenters.ClassesDetailPresenter;

import dagger.Subcomponent;

/**
 * Created by TranHuuPhuc on 12/4/18.
 */
@Subcomponent(modules = ClassesDetailModule.class)
public interface ClassesDetailComponent {
    ClassesDetailPresenter getClassesDetailPresenter();
}
