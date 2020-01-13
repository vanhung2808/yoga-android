package com.stdio.hue.yoga.modules.main.di;

import com.stdio.hue.yoga.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.databases.repositories.CategoryRepository;
import com.stdio.hue.yoga.databases.repositories.CollectionRepository;
import com.stdio.hue.yoga.databases.repositories.NewsRepository;
import com.stdio.hue.yoga.databases.repositories.PosesRepository;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenter;
import com.stdio.hue.yoga.modules.main.presenters.MainPresenterImpl;
import com.stdio.hue.yoga.modules.main.ui.actions.CollectionsClassesMainAction;
import com.stdio.hue.yoga.modules.main.ui.actions.MainAction;
import com.stdio.hue.yoga.modules.main.ui.actions.NewsAction;
import com.stdio.hue.yoga.modules.main.ui.actions.PosesOfPosesAction;

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
    PublishSubject<NewsAction> providesNewsActionPublishSubject() {
        return NewsAction.publisher;
    }

    @Provides
    PublishSubject<PosesOfPosesAction> providesPosesOfPosesActionPublishSubject(){
        return PosesOfPosesAction.publisher;
    }

    @Provides
    MainPresenter providesMainPresenter(PublishSubject<MainAction> mainActionPublishSubject, PublishSubject<CollectionsClassesMainAction> collectionsClassesMainState, PublishSubject<NewsAction> newsActionPublishSubject, PublishSubject<PosesOfPosesAction> posesOfPosesActionPublishSubject, BannerRepository bannerRepository, CategoryRepository categoryRepository, CollectionRepository collectionRepository, NewsRepository newsRepository, PosesRepository posesRepository) {
        return new MainPresenterImpl(mainActionPublishSubject, collectionsClassesMainState, newsActionPublishSubject,posesOfPosesActionPublishSubject, bannerRepository, categoryRepository, collectionRepository, newsRepository,posesRepository);
    }

}
