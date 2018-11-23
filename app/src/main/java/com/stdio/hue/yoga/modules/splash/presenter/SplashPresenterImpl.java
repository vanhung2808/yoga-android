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
import com.stdio.hue.yoga.data.usecases.GetPosesUseCase;
import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.databases.repositories.CategoryRepository;
import com.stdio.hue.yoga.databases.repositories.ClassesRepository;
import com.stdio.hue.yoga.databases.repositories.CollectionRepository;
import com.stdio.hue.yoga.databases.repositories.DurationRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.databases.repositories.IntensityRepository;
import com.stdio.hue.yoga.databases.repositories.PosesRepository;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by hung.nguyendk on 4/29/18.
 */
public class SplashPresenterImpl extends BasePresenter implements SplashPresenter {
    private GetAbilitiesUseCase getAbilitiesUseCase;
    private GetBannersUseCase getBannersUseCase;
    private GetCategoriesUseCase getCategoriesUseCase;
    private GetClassesUseCase getClassesUseCase;
    private GetCollectionsUseCase getCollectionsUseCase;
    private GetDurationsUseCase getDurationsUseCase;
    private GetFocusUseCase getFocusUseCase;
    private GetIntensitiesUseCase getIntensitiesUseCase;
    private GetPosesUseCase getPosesUseCase;

    private BannerRepository bannerRepository;
    private AbilityRepository abilityRepository;
    private CategoryRepository categoryRepository;
    private ClassesRepository classesRepository;
    private CollectionRepository collectionRepository;
    private DurationRepository durationRepository;
    private FocusRepository focusRepository;
    private IntensityRepository intensityRepository;
    private PosesRepository posesRepository;

    public SplashPresenterImpl(GetAbilitiesUseCase getAbilitiesUseCase, GetBannersUseCase getBannersUseCase, GetCategoriesUseCase getCategoriesUseCase, GetClassesUseCase getClassesUseCase, GetCollectionsUseCase getCollectionsUseCase, GetDurationsUseCase getDurationsUseCase, GetFocusUseCase getFocusUseCase, GetIntensitiesUseCase getIntensitiesUseCase, GetPosesUseCase getPosesUseCase, BannerRepository bannerRepository, AbilityRepository abilityRepository, CategoryRepository categoryRepository, ClassesRepository classesRepository, CollectionRepository collectionRepository, DurationRepository durationRepository, FocusRepository focusRepository, IntensityRepository intensityRepository, PosesRepository posesRepository) {
        this.getAbilitiesUseCase = getAbilitiesUseCase;
        this.getBannersUseCase = getBannersUseCase;
        this.getCategoriesUseCase = getCategoriesUseCase;
        this.getClassesUseCase = getClassesUseCase;
        this.getCollectionsUseCase = getCollectionsUseCase;
        this.getDurationsUseCase = getDurationsUseCase;
        this.getFocusUseCase = getFocusUseCase;
        this.getIntensitiesUseCase = getIntensitiesUseCase;
        this.getPosesUseCase = getPosesUseCase;
        this.bannerRepository = bannerRepository;
        this.abilityRepository = abilityRepository;
        this.categoryRepository = categoryRepository;
        this.classesRepository = classesRepository;
        this.collectionRepository = collectionRepository;
        this.durationRepository = durationRepository;
        this.focusRepository = focusRepository;
        this.intensityRepository = intensityRepository;
        this.posesRepository = posesRepository;
    }

    @Override
    public Observable<Boolean> getAllDataAndSaveLocal(Integer timeUpdate, String language) {
        return Observable.combineLatest(
                getAbilities(timeUpdate, language),
                getBanners(timeUpdate, language),
                getCategories(timeUpdate, language),
                getClasses(timeUpdate, language),
                getCollections(timeUpdate, language),
                getDurations(timeUpdate, language),
                getFocus(timeUpdate, language),
                getIntensities(timeUpdate, language),
                getPoses(timeUpdate, language),
                (ability, banner, category, classes, collection, duration, focus, intensity, poses) -> true)
                .observeOn(AndroidSchedulers.mainThread()).map(result -> result);
    }

    private Observable<Boolean> getAbilities(Integer timeUpdate, String language) {
        return getAbilitiesUseCase.execute(timeUpdate, language)
                .map(results -> {
                    abilityRepository.insertAbility(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getBanners(Integer timeUpdate, String language) {
        return getBannersUseCase.execute(timeUpdate, language)
                .map(results -> {
                    bannerRepository.insertBanner(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getCategories(Integer timeUpdate, String language) {
        return getCategoriesUseCase.execute(timeUpdate, language)
                .map(results -> {
                    categoryRepository.insertCategory(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getClasses(Integer timeUpdate, String language) {
        return getClassesUseCase.execute(timeUpdate, language)
                .map(results -> {
                    classesRepository.insertClasses(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getCollections(Integer timeUpdate, String language) {
        return getCollectionsUseCase.execute(timeUpdate, language)
                .map(results -> {
                    collectionRepository.insertCollection(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getDurations(Integer timeUpdate, String language) {
        return getDurationsUseCase.execute(timeUpdate, language)
                .map(results -> {
                    durationRepository.insertDuration(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getFocus(Integer timeUpdate, String language) {
        return getFocusUseCase.execute(timeUpdate, language)
                .map(results -> {
                    focusRepository.insertFocus(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getIntensities(Integer timeUpdate, String language) {
        return getIntensitiesUseCase.execute(timeUpdate, language)
                .map(results -> {
                    intensityRepository.insertIntensity(results.getData());
                    return true;
                });
    }

    private Observable<Boolean> getPoses(Integer timeUpdate, String language) {
        return getPosesUseCase.execute(timeUpdate, language)
                .map(results -> {
                    posesRepository.insertPoses(results.getData());
                    return true;
                });
    }
}
