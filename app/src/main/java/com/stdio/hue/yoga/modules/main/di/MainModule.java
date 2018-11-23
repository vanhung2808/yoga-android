package com.stdio.hue.yoga.modules.main.di;

import com.stdio.hue.yoga.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenter;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenterImpl;
import com.stdio.hue.yoga.modules.main.ui.actions.CollectionsClassesMainAction;
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
    PublishSubject<CollectionsClassesMainAction> providesCollectionsClassesMainActionPublishSubject() {
        return CollectionsClassesMainAction.publisher;
    }

    @Provides
    MainPresenter providesMainPresenter(PublishSubject<MainAction> mainActionPublishSubject, BannerRepository bannerRepository) {
        return new MainPresenterImpl(mainActionPublishSubject, bannerRepository);
    }

}
