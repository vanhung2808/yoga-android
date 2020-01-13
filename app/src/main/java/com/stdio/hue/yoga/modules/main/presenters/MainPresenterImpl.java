package com.stdio.hue.yoga.modules.main.presenters;

import android.annotation.SuppressLint;

import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.databases.repositories.CategoryRepository;
import com.stdio.hue.yoga.databases.repositories.CollectionRepository;
import com.stdio.hue.yoga.databases.repositories.NewsRepository;
import com.stdio.hue.yoga.databases.repositories.PosesRepository;
import com.stdio.hue.yoga.modules.main.ui.actions.CollectionsClassesMainAction;
import com.stdio.hue.yoga.modules.main.ui.actions.MainAction;
import com.stdio.hue.yoga.modules.main.ui.actions.NewsAction;
import com.stdio.hue.yoga.modules.main.ui.actions.PosesOfPosesAction;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class MainPresenterImpl extends BasePresenter implements MainPresenter {
    private PublishSubject<MainAction> mainActionPublishSubject;
    private PublishSubject<CollectionsClassesMainAction> collectionsClassesMainState;
    private PublishSubject<NewsAction> newsActionPublishSubject;
    private PublishSubject<PosesOfPosesAction> posesOfPosesActionPublishSubject;
    private BannerRepository bannerRepository;
    private CategoryRepository categoryRepository;
    private CollectionRepository collectionRepository;
    private NewsRepository newsRepository;
    private PosesRepository posesRepository;


    public MainPresenterImpl(PublishSubject<MainAction> mainActionPublishSubject, PublishSubject<CollectionsClassesMainAction> collectionsClassesMainState, PublishSubject<NewsAction> newsActionPublishSubject, PublishSubject<PosesOfPosesAction> posesOfPosesActionPublishSubject, BannerRepository bannerRepository, CategoryRepository categoryRepository, CollectionRepository collectionRepository, NewsRepository newsRepository, PosesRepository posesRepository) {
        this.mainActionPublishSubject = mainActionPublishSubject;
        this.collectionsClassesMainState = collectionsClassesMainState;
        this.newsActionPublishSubject = newsActionPublishSubject;
        this.posesOfPosesActionPublishSubject = posesOfPosesActionPublishSubject;
        this.bannerRepository = bannerRepository;
        this.categoryRepository = categoryRepository;
        this.collectionRepository = collectionRepository;
        this.newsRepository = newsRepository;
        this.posesRepository = posesRepository;
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
    public Observable<List<Collection>> getCollectionsOfACategory(int categoryId) {
        return Observable.just(collectionRepository.getCollectionsOfCategory(categoryId))
                .subscribeOn(Schedulers.io())
                .map(collections -> collections);
    }

    @Override
    public void getAllNews() {
        disposable.add(Observable.just(newsRepository.getAllNews())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<News>>() {
                    @Override
                    public void accept(List<News> news) throws Exception {
                        newsActionPublishSubject.onNext(NewsAction.setNews(news));
                    }
                }));
    }

    @Override
    public void getAllPoses() {
        disposable.add(Observable.just(posesRepository.getPosesDetail())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<Poses>>() {
                    @Override
                    public void accept(List<Poses> poses) throws Exception {
                        posesOfPosesActionPublishSubject.onNext(PosesOfPosesAction.setPoses(poses));
                    }
                }));
    }

}
