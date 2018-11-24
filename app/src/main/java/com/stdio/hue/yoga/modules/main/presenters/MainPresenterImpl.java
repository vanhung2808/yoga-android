package com.stdio.hue.yoga.modules.main.presenters;

import android.annotation.SuppressLint;

import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.databases.repositories.CategoryRepository;
import com.stdio.hue.yoga.databases.repositories.CollectionRepository;
import com.stdio.hue.yoga.modules.main.ui.actions.CollectionsClassesMainAction;
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
    private PublishSubject<CollectionsClassesMainAction> collectionsClassesMainState;
    private BannerRepository bannerRepository;
    private CategoryRepository categoryRepository;
    private CollectionRepository collectionRepository;

    public MainPresenterImpl(PublishSubject<MainAction> mainActionPublishSubject, PublishSubject<CollectionsClassesMainAction> collectionsClassesMainState, BannerRepository bannerRepository, CategoryRepository categoryRepository, CollectionRepository collectionRepository) {
        this.mainActionPublishSubject = mainActionPublishSubject;
        this.collectionsClassesMainState = collectionsClassesMainState;
        this.bannerRepository = bannerRepository;
        this.categoryRepository = categoryRepository;
        this.collectionRepository = collectionRepository;
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
        disposable.add(Observable.just(categoryRepository.getAllCategory())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(categories -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.setCategories(categories))));
    }

    @Override
    public void getCollectionsOfACategory(int categoryId) {
        disposable.add(Observable.just(collectionRepository.getCollectionsOfCategory(categoryId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(collections -> collectionsClassesMainState.onNext(CollectionsClassesMainAction.setCollectionsOfCategory(collections))));
    }
}
