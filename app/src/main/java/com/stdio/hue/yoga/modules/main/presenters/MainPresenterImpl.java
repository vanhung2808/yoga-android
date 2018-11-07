package com.stdio.hue.yoga.modules.main.presenters;

import com.stdio.hue.yoga.base.core.mvp.BasePresenter;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class MainPresenterImpl extends BasePresenter implements MainPresenter {

    public MainPresenterImpl() {
    }

    @Override
    public void getBanners() {
//        disposable.add(getBannersUseCase.execute("vi")
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(d -> mainActionState.onNext(MainAction.isLoading(true)))
//                .doOnError(throwable -> mainActionState.onNext(MainAction.isLoading(false)))
//                .doOnComplete(() -> mainActionState.onNext(MainAction.isLoading(false)))
//                .subscribe(baseResponse -> {
//                    if (baseResponse.isHasError()) {
//                        mainActionState.onNext(MainAction.error(baseResponse.getErrors().get(0).getMessage()));
//                    } else {
//                        if (baseResponse.getData() != null && !baseResponse.getData().isEmpty()) {
//                            mainActionState.onNext(MainAction.setBanners(baseResponse.getData()));
//                        }
//                    }
//                }, throwable -> mainActionState.onNext(MainAction.error(throwable.getMessage()))));
    }

    @Override
    public void getAllCategories() {
//        disposable.add(getAllCategoryUseCase.execute("vi")
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(d -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(true)))
//                .doOnError(throwable -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(false)))
//                .doOnComplete(() -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(false)))
//                .subscribe(baseResponse -> {
//                    if (baseResponse.hasErrors()) {
//                        collectionsClassesMainState.onNext(CollectionsClassesMainAction.error(baseResponse.errors().get(0).message()));
//                    } else {
//                        if (baseResponse.data() != null && baseResponse.data().categories() != null && !baseResponse.data().categories().isEmpty()) {
//                            collectionsClassesMainState.onNext(CollectionsClassesMainAction.setCategories(baseResponse.data().categories()));
//                        }
//                    }
//                }, throwable -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.error(throwable.getMessage()))));
    }

    @Override
    public void getCollectionsOfACategory(int categoryId, int limit, int pageIndex, String where) {
//        disposable.add(getCollectionOfCategoryUseCase.execute(limit, pageIndex, categoryId, where, "vi")
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(d -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(true)))
//                .doOnError(throwable -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(false)))
//                .doOnComplete(() -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.isLoading(false)))
//                .subscribe(baseResponse -> {
//                    if (baseResponse.hasErrors()) {
//                        collectionsClassesMainState.onNext(CollectionsClassesMainAction.error(baseResponse.errors().get(0).message()));
//                    } else {
//                        if (baseResponse.data() != null && baseResponse.data().collection() != null && baseResponse.data().collection().data() != null && !baseResponse.data().collection().data().isEmpty()) {
//                            collectionsClassesMainState.onNext(CollectionsClassesMainAction.setCollections(baseResponse.data().collection().data()));
//                        }
//                    }
//                }, throwable -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.error(throwable.getMessage()))));
    }
}
