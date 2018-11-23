package com.stdio.hue.yoga.modules.main.presenters;

import android.annotation.SuppressLint;

import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.modules.main.ui.actions.MainAction;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class MainPresenterImpl extends BasePresenter implements MainPresenter {
    private PublishSubject<MainAction> mainActionPublishSubject;
    private BannerRepository bannerRepository;

    public MainPresenterImpl(PublishSubject<MainAction> mainActionPublishSubject, BannerRepository bannerRepository) {
        this.mainActionPublishSubject = mainActionPublishSubject;
        this.bannerRepository = bannerRepository;
    }

    @SuppressLint("RxSubscribeOnError")
    @Override
    public void getBanners() {
        disposable.add(Observable.just(bannerRepository.getAllBanner())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(banners -> mainActionPublishSubject.onNext(MainAction.setBanners(banners))));
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
    public void getCollectionsOfACategory(int categoryId, int limit, int pageIndex, String
            where) {
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
