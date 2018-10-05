package com.stdio.hue.yoga.modules.main.di;

import com.stdio.hue.yoga.data.usecases.GetAllCategoryUseCase;
import com.stdio.hue.yoga.data.usecases.GetBannersUseCase;
import com.stdio.hue.yoga.data.usecases.GetCollectionOfCategoryUseCase;
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
    MainPresenter providesMainPresenter(GetBannersUseCase getBannersUseCase, GetAllCategoryUseCase getAllCategoryUseCase, GetCollectionOfCategoryUseCase getCollectionOfCategoryUseCase, PublishSubject<MainAction> actionPublishSubject, PublishSubject<CollectionsClassesMainAction> collectionsClassesMainState) {
        return new MainPresenterImpl(getBannersUseCase, getAllCategoryUseCase, getCollectionOfCategoryUseCase, actionPublishSubject, collectionsClassesMainState);
    }

}
