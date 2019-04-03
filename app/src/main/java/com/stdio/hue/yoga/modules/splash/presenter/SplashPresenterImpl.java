package com.stdio.hue.yoga.modules.splash.presenter;

import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.usecases.GetAbilitiesUseCase;
import com.stdio.hue.yoga.data.usecases.GetBannersUseCase;
import com.stdio.hue.yoga.data.usecases.GetCategoriesUseCase;
import com.stdio.hue.yoga.data.usecases.GetClassesUseCase;
import com.stdio.hue.yoga.data.usecases.GetCollectionsUseCase;
import com.stdio.hue.yoga.data.usecases.GetDurationsUseCase;
import com.stdio.hue.yoga.data.usecases.GetFocusUseCase;
import com.stdio.hue.yoga.data.usecases.GetIntensitiesUseCase;
import com.stdio.hue.yoga.data.usecases.GetNewsUseCase;
import com.stdio.hue.yoga.data.usecases.GetPosesUseCase;
import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.databases.repositories.CategoryRepository;
import com.stdio.hue.yoga.databases.repositories.ClassesRepository;
import com.stdio.hue.yoga.databases.repositories.CollectionRepository;
import com.stdio.hue.yoga.databases.repositories.DurationRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.databases.repositories.IntensityRepository;
import com.stdio.hue.yoga.databases.repositories.NewsRepository;
import com.stdio.hue.yoga.databases.repositories.PosesRepository;
import com.stdio.hue.yoga.modules.splash.ui.SplashAction;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by hung.nguyendk on 4/29/18.
 */
public class SplashPresenterImpl extends BasePresenter implements SplashPresenter {
    private PublishSubject<SplashAction> splashPublishSubject;
    private GetAbilitiesUseCase getAbilitiesUseCase;
    private GetBannersUseCase getBannersUseCase;
    private GetCategoriesUseCase getCategoriesUseCase;
    private GetClassesUseCase getClassesUseCase;
    private GetCollectionsUseCase getCollectionsUseCase;
    private GetDurationsUseCase getDurationsUseCase;
    private GetFocusUseCase getFocusUseCase;
    private GetIntensitiesUseCase getIntensitiesUseCase;
    private GetPosesUseCase getPosesUseCase;
    private GetNewsUseCase getNewsUseCase;

    private BannerRepository bannerRepository;
    private AbilityRepository abilityRepository;
    private CategoryRepository categoryRepository;
    private ClassesRepository classesRepository;
    private CollectionRepository collectionRepository;
    private DurationRepository durationRepository;
    private FocusRepository focusRepository;
    private IntensityRepository intensityRepository;
    private PosesRepository posesRepository;
    private NewsRepository newsRepository;

    public SplashPresenterImpl(PublishSubject<SplashAction> splashPublishSubject, GetAbilitiesUseCase getAbilitiesUseCase, GetBannersUseCase getBannersUseCase, GetCategoriesUseCase getCategoriesUseCase, GetClassesUseCase getClassesUseCase, GetCollectionsUseCase getCollectionsUseCase, GetDurationsUseCase getDurationsUseCase, GetFocusUseCase getFocusUseCase, GetIntensitiesUseCase getIntensitiesUseCase, GetPosesUseCase getPosesUseCase, GetNewsUseCase getNewsUseCase, BannerRepository bannerRepository, AbilityRepository abilityRepository, CategoryRepository categoryRepository, ClassesRepository classesRepository, CollectionRepository collectionRepository, DurationRepository durationRepository, FocusRepository focusRepository, IntensityRepository intensityRepository, PosesRepository posesRepository, NewsRepository newsRepository) {
        this.splashPublishSubject = splashPublishSubject;
        this.getAbilitiesUseCase = getAbilitiesUseCase;
        this.getBannersUseCase = getBannersUseCase;
        this.getCategoriesUseCase = getCategoriesUseCase;
        this.getClassesUseCase = getClassesUseCase;
        this.getCollectionsUseCase = getCollectionsUseCase;
        this.getDurationsUseCase = getDurationsUseCase;
        this.getFocusUseCase = getFocusUseCase;
        this.getIntensitiesUseCase = getIntensitiesUseCase;
        this.getPosesUseCase = getPosesUseCase;
        this.getNewsUseCase = getNewsUseCase;
        this.bannerRepository = bannerRepository;
        this.abilityRepository = abilityRepository;
        this.categoryRepository = categoryRepository;
        this.classesRepository = classesRepository;
        this.collectionRepository = collectionRepository;
        this.durationRepository = durationRepository;
        this.focusRepository = focusRepository;
        this.intensityRepository = intensityRepository;
        this.posesRepository = posesRepository;
        this.newsRepository = newsRepository;
    }

    @Override
    public Observable<Object[]> getAllDataAndSaveLocal(String timeUpdate, String language) {
        List<Observable<?>> list = Arrays.asList(
                getAbilities(timeUpdate, language),
                getBanners(timeUpdate, language),
                getCategories(timeUpdate, language),
                getClasses(timeUpdate, language),
                getCollections(timeUpdate, language),
                getDurations(timeUpdate, language),
                getFocus(timeUpdate, language),
                getIntensities(timeUpdate, language),
                getPoses(timeUpdate, language),
                getNews(timeUpdate, language));
        return Observable.combineLatest(list, objects -> objects).observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<Boolean> getAbilities(String timeUpdate, String language) {
        return getAbilitiesUseCase.execute(timeUpdate, language)
                .doOnComplete(() -> splashPublishSubject.onNext(SplashAction.setProgess(1)))
                .map(results -> {
                    abilityRepository.insertAbility(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getBanners(String timeUpdate, String language) {
        return getBannersUseCase.execute(timeUpdate, language)
                .doOnComplete(() -> splashPublishSubject.onNext(SplashAction.setProgess(1)))
                .map(results -> {
                    bannerRepository.insertBanner(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getCategories(String timeUpdate, String language) {
        return getCategoriesUseCase.execute(timeUpdate, language)
                .doOnComplete(() -> splashPublishSubject.onNext(SplashAction.setProgess(1)))
                .map(results -> {
                    categoryRepository.insertCategory(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getClasses(String timeUpdate, String language) {
        return getClassesUseCase.execute(timeUpdate, language)
                .doOnComplete(() -> splashPublishSubject.onNext(SplashAction.setProgess(1)))
                .map(results -> {
                    classesRepository.insertClasses(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getCollections(String timeUpdate, String language) {
        return getCollectionsUseCase.execute(timeUpdate, language)
                .doOnComplete(() -> splashPublishSubject.onNext(SplashAction.setProgess(1)))
                .map(results -> {
                    collectionRepository.insertCollection(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getDurations(String timeUpdate, String language) {
        return getDurationsUseCase.execute(timeUpdate, language)
                .doOnComplete(() -> splashPublishSubject.onNext(SplashAction.setProgess(1)))
                .map(results -> {
                    durationRepository.insertDuration(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getFocus(String timeUpdate, String language) {
        return getFocusUseCase.execute(timeUpdate, language)
                .doOnComplete(() -> splashPublishSubject.onNext(SplashAction.setProgess(1)))
                .map(results -> {
                    focusRepository.insertFocus(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getIntensities(String timeUpdate, String language) {
        return getIntensitiesUseCase.execute(timeUpdate, language)
                .doOnComplete(() -> splashPublishSubject.onNext(SplashAction.setProgess(1)))
                .map(results -> {
                    intensityRepository.insertIntensity(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getPoses(String timeUpdate, String language) {
        return getPosesUseCase.execute(timeUpdate, language)
                .doOnComplete(() -> splashPublishSubject.onNext(SplashAction.setProgess(1)))
                .map(results -> {
                    posesRepository.insertPoses(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getNews(String timeUpdate, String language) {
        return getNewsUseCase.execute(timeUpdate, language)
                .doOnComplete(() -> splashPublishSubject.onNext(SplashAction.setProgess(1)))
                .map(results -> {
                    newsRepository.insertNews(results.getData());
                    return true;
                });
    }
}
