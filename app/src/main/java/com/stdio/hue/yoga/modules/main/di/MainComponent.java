package com.stdio.hue.yoga.modules.main.di;

import com.stdio.hue.yoga.modules.main.presenters.MainPresenter;
import com.stdio.hue.yoga.modules.main.ui.actions.CollectionsClassesMainAction;
import com.stdio.hue.yoga.modules.main.ui.actions.MainAction;
import com.stdio.hue.yoga.modules.main.ui.actions.NewsAction;
import com.stdio.hue.yoga.modules.main.ui.actions.PosesOfPosesAction;

import dagger.Subcomponent;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 7/13/18.
 */
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    PublishSubject<MainAction> getMainState();

    PublishSubject<CollectionsClassesMainAction> getCollectionsClassesMainState();

    PublishSubject<NewsAction> getNewsMainState();

    MainPresenter getMainPresenter();

    PublishSubject<PosesOfPosesAction> getPosesOfPosesMainState();
}
