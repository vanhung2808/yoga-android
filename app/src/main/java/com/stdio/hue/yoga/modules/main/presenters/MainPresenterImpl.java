package com.stdio.hue.yoga.modules.main.presenters;

import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.usecases.GetAllCategoryUseCase;
import com.stdio.hue.yoga.data.usecases.GetBannersUseCase;
import com.stdio.hue.yoga.data.usecases.GetCollectionOfCategoryUseCase;
import com.stdio.hue.yoga.modules.main.ui.actions.CollectionsClassesMainAction;
import com.stdio.hue.yoga.modules.main.ui.actions.MainAction;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class MainPresenterImpl extends BasePresenter implements MainPresenter {
    private GetBannersUseCase getBannersUseCase;
    private GetAllCategoryUseCase getAllCategoryUseCase;
    private GetCollectionOfCategoryUseCase getCollectionOfCategoryUseCase;
    private PublishSubject<MainAction> mainActionState;
    private PublishSubject<CollectionsClassesMainAction> collectionsClassesMainState;

    public MainPresenterImpl(GetBannersUseCase getBannersUseCase, GetAllCategoryUseCase getAllCategoryUseCase, GetCollectionOfCategoryUseCase getCollectionOfCategoryUseCase, PublishSubject<MainAction> mainActionState, PublishSubject<CollectionsClassesMainAction> collectionsClassesMainState) {
        this.getBannersUseCase = getBannersUseCase;
        this.getAllCategoryUseCase = getAllCategoryUseCase;
        this.getCollectionOfCategoryUseCase = getCollectionOfCategoryUseCase;
        this.mainActionState = mainActionState;
        this.collectionsClassesMainState = collectionsClassesMainState;
    }

    @Override
    public void getBanners() {
        disposable.add(getBannersUseCase.execute("vi")
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> mainActionState.onNext(MainAction.isLoading(true)))
                .doOnError(throwable -> mainActionState.onNext(MainAction.isLoading(false)))
                .doOnComplete(() -> mainActionState.onNext(MainAction.isLoading(false)))
                .subscribe(baseResponse -> {
                    if (baseResponse.hasErrors()) {
                        mainActionState.onNext(MainAction.error(baseResponse.errors().get(0).message()));
                    } else {
                        if (baseResponse.data() != null && baseResponse.data().banner() != null && !baseResponse.data().banner().isEmpty()) {
                            mainActionState.onNext(MainAction.setBanners(baseResponse.data().banner()));
                        }
                    }
                }, throwable -> mainActionState.onNext(MainAction.error(throwable.getMessage()))));
    }

    @Override
    public void getAllCategories() {
        disposable.add(getAllCategoryUseCase.execute("vi")
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(true)))
                .doOnError(throwable -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(false)))
                .doOnComplete(() -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(false)))
                .subscribe(baseResponse -> {
                    if (baseResponse.hasErrors()) {
                        collectionsClassesMainState.onNext(CollectionsClassesMainAction.error(baseResponse.errors().get(0).message()));
                    } else {
                        if (baseResponse.data() != null && baseResponse.data().categories() != null && !baseResponse.data().categories().isEmpty()) {
                            collectionsClassesMainState.onNext(CollectionsClassesMainAction.setCategories(baseResponse.data().categories()));
                        }
                    }
                }, throwable -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.error(throwable.getMessage()))));
    }

    @Override
    public void getCollectionsOfACategory(int categoryId, int limit, int pageIndex, String where) {
        disposable.add(getCollectionOfCategoryUseCase.execute(limit, pageIndex, categoryId, where, "vi")
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(true)))
                .doOnError(throwable -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(false)))
                .doOnComplete(() -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(false)))
                .subscribe(baseResponse -> {
                    if (baseResponse.hasErrors()) {
                        collectionsClassesMainState.onNext(CollectionsClassesMainAction.error(baseResponse.errors().get(0).message()));
                    } else {
                        if (baseResponse.data() != null && baseResponse.data().collection() != null && baseResponse.data().collection().data() != null && !baseResponse.data().collection().data().isEmpty()) {
                            collectionsClassesMainState.onNext(CollectionsClassesMainAction.setCollections(baseResponse.data().collection().data()));
                        }
                    }
                }, throwable -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.error(throwable.getMessage()))));
    }
}
