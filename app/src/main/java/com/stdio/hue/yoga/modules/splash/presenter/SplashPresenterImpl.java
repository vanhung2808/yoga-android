package com.stdio.hue.yoga.modules.splash.presenter;

import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.usecases.servers.GetAbilitiesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetBannersUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetCategoriesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetClassesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetCollectionsUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetDurationsUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetFocusUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetIntensitiesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetPosesUseCase;

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


    public SplashPresenterImpl(GetAbilitiesUseCase getAbilitiesUseCase, GetBannersUseCase getBannersUseCase, GetCategoriesUseCase getCategoriesUseCase, GetClassesUseCase getClassesUseCase, GetCollectionsUseCase getCollectionsUseCase, GetDurationsUseCase getDurationsUseCase, GetFocusUseCase getFocusUseCase, GetIntensitiesUseCase getIntensitiesUseCase, GetPosesUseCase getPosesUseCase) {
        this.getAbilitiesUseCase = getAbilitiesUseCase;
        this.getBannersUseCase = getBannersUseCase;
        this.getCategoriesUseCase = getCategoriesUseCase;
        this.getClassesUseCase = getClassesUseCase;
        this.getCollectionsUseCase = getCollectionsUseCase;
        this.getDurationsUseCase = getDurationsUseCase;
        this.getFocusUseCase = getFocusUseCase;
        this.getIntensitiesUseCase = getIntensitiesUseCase;
        this.getPosesUseCase = getPosesUseCase;
    }


    @Override
    public void getAllDataAndSaveLocal(Integer timeUpdate, String language) {
        disposable.add(Observable.combineLatest(
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
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> {

                })
                .doOnComplete(() -> {

                })
                .doOnError((error) -> {

                })
                .subscribe(result -> {
                    if (result) {

                    }
                }, error -> {
                }));
    }

    private Observable<Boolean> getAbilities(Integer timeUpdate, String language) {
        return getAbilitiesUseCase.execute(timeUpdate, language)
                .map(results -> results);
    }

    private Observable<Boolean> getBanners(Integer timeUpdate, String language) {
        return getBannersUseCase.execute(timeUpdate, language)
                .map(results -> results);
    }

    private Observable<Boolean> getCategories(Integer timeUpdate, String language) {
        return getCategoriesUseCase.execute(timeUpdate, language)
                .map(results -> results);
    }

    private Observable<Boolean> getClasses(Integer timeUpdate, String language) {
        return getClassesUseCase.execute(timeUpdate, language)
                .map(results -> results);
    }

    private Observable<Boolean> getCollections(Integer timeUpdate, String language) {
        return getCollectionsUseCase.execute(timeUpdate, language)
                .map(results -> results);
    }

    private Observable<Boolean> getDurations(Integer timeUpdate, String language) {
        return getDurationsUseCase.execute(timeUpdate, language)
                .map(results -> results);
    }

    private Observable<Boolean> getFocus(Integer timeUpdate, String language) {
        return getFocusUseCase.execute(timeUpdate, language)
                .map(results -> results);
    }

    private Observable<Boolean> getIntensities(Integer timeUpdate, String language) {
        return getIntensitiesUseCase.execute(timeUpdate, language)
                .map(results -> results);
    }

    private Observable<Boolean> getPoses(Integer timeUpdate, String language) {
        return getPosesUseCase.execute(timeUpdate, language)
                .map(results -> results);
    }
}
