package com.stdio.hue.yoga.modules.main.di;

import com.stdio.hue.yoga.modules.main.presenters.MainPresenter;
import com.stdio.hue.yoga.modules.main.ui.actions.MainAction;

import dagger.Subcomponent;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 7/13/18.
 */
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    PublishSubject<MainAction> getMainState();

    MainPresenter getMainPresenter();
}
