package com.stdio.hue.yoga.modules.classes.searchs.presenters.impl;

import com.google.gson.Gson;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.models.Ability;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.data.models.Duration;
import com.stdio.hue.yoga.data.models.Focus;
import com.stdio.hue.yoga.data.models.Intensity;
import com.stdio.hue.yoga.data.models.base.BaseFilter;
import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.ClassesRepository;
import com.stdio.hue.yoga.databases.repositories.DurationRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.databases.repositories.IntensityRepository;
import com.stdio.hue.yoga.modules.classes.searchs.presenters.SearchClassesPresenter;
import com.stdio.hue.yoga.modules.classes.searchs.ui.actions.SearchClassesAction;
import com.stdio.hue.yoga.modules.collections.models.FilterClasses;
import com.stdio.hue.yoga.shares.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 11/24/18.
 */
public class SearchClassesPresenterImpl extends BasePresenter implements SearchClassesPresenter {
    private PublishSubject<SearchClassesAction> searchClassesActionPublishSubject;
    private AbilityRepository abilityRepository;
    private FocusRepository focusRepository;
    private DurationRepository durationRepository;
    private IntensityRepository intensityRepository;
    private ClassesRepository classesRepository;
    private Gson gson;


    public SearchClassesPresenterImpl(PublishSubject<SearchClassesAction> searchClassesActionPublishSubject, AbilityRepository abilityRepository, FocusRepository focusRepository, DurationRepository durationRepository, IntensityRepository intensityRepository, ClassesRepository classesRepository, Gson gson) {
        this.searchClassesActionPublishSubject = searchClassesActionPublishSubject;
        this.abilityRepository = abilityRepository;
        this.focusRepository = focusRepository;
        this.durationRepository = durationRepository;
        this.intensityRepository = intensityRepository;
        this.classesRepository = classesRepository;
        this.gson = gson;
    }

    @Override
    public void getFilterData() {
        disposable.add(
                Observable.combineLatest(
                        getAbilities(),
                        getDurations(),
                        getFocus(),
                        getIntensities(),
                        (ability, duration, focus, intensity) -> {
                            List<Object> list = new ArrayList<>();
                            list.add(ability);
                            list.add(duration);
                            list.add(focus);
                            list.add(intensity);
                            return list;
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(result -> searchClassesActionPublishSubject.onNext(SearchClassesAction.setDataFilter(result))));
    }

    @Override
    public void getClassesByIntensityId(List<BaseFilter> filterIntensity) {
        disposable.add(Observable.just(filterIntensity)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(intensities -> {
                    List<FilterClasses> filterClassesList = new ArrayList<>();
                    for (BaseFilter baseFilter : intensities) {
                        List<Classes> listClasses = classesRepository.searchClassesByIntensityId(baseFilter.getId());
                        if (listClasses != null && !listClasses.isEmpty()) {
                            filterClassesList.add(new FilterClasses(listClasses, baseFilter.getNameEntity(gson).getNameLocale()));
                        }
                    }
                    searchClassesActionPublishSubject.onNext(SearchClassesAction.setFilterIntensityClasses(filterClassesList));
                }));
    }

    @Override
    public void getClassesByFocusId(List<BaseFilter> filterFocus) {
        disposable.add(Observable.just(filterFocus)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(focus -> {
                    List<FilterClasses> filterClassesList = new ArrayList<>();
                    for (BaseFilter baseFilter : focus) {
                        List<Classes> listClasses = classesRepository.searchClassesByFocusId(baseFilter.getId());
                        if (listClasses != null && !listClasses.isEmpty()) {
                            filterClassesList.add(new FilterClasses(listClasses, baseFilter.getNameEntity(gson).getNameLocale()));
                        }
                    }
                    searchClassesActionPublishSubject.onNext(SearchClassesAction.setFilterFocusClasses(filterClassesList));
                }));
    }

    @Override
    public void getClassesByDurationId(List<BaseFilter> filterDuration) {
        disposable.add(Observable.just(filterDuration)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(durations -> {
                    List<FilterClasses> filterClassesList = new ArrayList<>();
                    for (BaseFilter baseFilter : durations) {
                        List<Classes> listClasses = classesRepository.searchClassesByDurationId(baseFilter.getId());
                        if (listClasses != null && !listClasses.isEmpty()) {
                            filterClassesList.add(new FilterClasses(listClasses, baseFilter.getNameEntity(gson).getNameLocale()));
                        }
                    }
                    searchClassesActionPublishSubject.onNext(SearchClassesAction.setFilterDurationClasses(filterClassesList));
                }));
    }

    @Override
    public void getClassesByAbilityId(List<BaseFilter> filterAbility) {
        disposable.add(Observable.just(filterAbility)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(abilities -> {
                    List<FilterClasses> filterClassesList = new ArrayList<>();
                    for (BaseFilter baseFilter : abilities) {
                        List<Classes> listClasses = classesRepository.searchClassesByAbilityId(baseFilter.getId());
                        if (listClasses != null && !listClasses.isEmpty()) {
                            filterClassesList.add(new FilterClasses(listClasses, baseFilter.getNameEntity(gson).getNameLocale()));
                        }
                    }
                    searchClassesActionPublishSubject.onNext(SearchClassesAction.setFilterAbilityClasses(filterClassesList));
                }));
    }

    @Override
    public void getClassesResultFilter(int typeFilter, List<BaseFilter> baseFilters) {
        switch (typeFilter) {
            case Constant.TAB_ABILITY:
                getClassesByAbilityId(baseFilters);
                break;
            case Constant.TAB_FOCUS:
                getClassesByFocusId(baseFilters);
                break;
            case Constant.TAB_DURATION:
                getClassesByDurationId(baseFilters);
            case Constant.TAB_INTENSITY:
            default:
                getClassesByIntensityId(baseFilters);
                break;
        }
    }

    private Observable<List<Ability>> getAbilities() {
        return Observable.just(abilityRepository.getAllAbility());
    }

    private Observable<List<Duration>> getDurations() {
        return Observable.just(durationRepository.getAllDuration());

    }

    private Observable<List<Focus>> getFocus() {
        return Observable.just(focusRepository.getAllFocus());
    }

    private Observable<List<Intensity>> getIntensities() {
        return Observable.just(intensityRepository.getAllIntensity());
    }
}
