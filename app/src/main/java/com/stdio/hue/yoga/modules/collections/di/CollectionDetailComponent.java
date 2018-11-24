package com.stdio.hue.yoga.modules.collections.di;

import com.stdio.hue.yoga.modules.collections.presenter.ClassesCollectionDetailPresenter;
import com.stdio.hue.yoga.modules.collections.ui.actions.ClassesCollectionDetailAction;

import dagger.Subcomponent;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 11/23/18.
 */
@Subcomponent(modules = CollectionDetailModule.class)
public interface CollectionDetailComponent {
    ClassesCollectionDetailPresenter getClassesCollectionDetailPresenter();

    PublishSubject<ClassesCollectionDetailAction> getClassesCollectionDetailAction();
}
