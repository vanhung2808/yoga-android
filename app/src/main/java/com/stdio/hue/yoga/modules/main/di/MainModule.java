package com.stdio.hue.yoga.modules.main.di;

import com.stdio.hue.yoga.data.usecases.GetBannersUseCase;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenter;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenterImpl;
import com.stdio.hue.yoga.modules.main.ui.actions.MainAction;

import dagger.Module;
import dagger.Provides;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 7/13/18.
 */
@Module
public class MainModule {
    @Provides
    PublishSubject<MainAction> providesMainActionPublishSubject() {
        return MainAction.publisher;
    }

    @Provides
    MainPresenter providesMainPresenter(GetBannersUseCase getBannersUseCase, PublishSubject<MainAction> actionPublishSubject) {
        return new MainPresenterImpl(getBannersUseCase, actionPublishSubject);
    }

}
