package com.stdio.hue.yoga.modules.collections.presenter;

import com.google.gson.Gson;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.models.Ability;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.data.models.Duration;
import com.stdio.hue.yoga.data.models.Focus;
import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.ClassesRepository;
import com.stdio.hue.yoga.databases.repositories.DurationRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.modules.collections.models.FilterClasses;
import com.stdio.hue.yoga.modules.collections.ui.actions.ClassesCollectionDetailAction;
import com.stdio.hue.yoga.shares.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 11/23/18.
 */
public class ClassesCollectionDetailPresenterImpl extends BasePresenter implements ClassesCollectionDetailPresenter {
    private ClassesRepository classesRepository;
    private AbilityRepository abilityRepository;
    private FocusRepository focusRepository;
    private DurationRepository durationRepository;
    private Gson gson;
    private PublishSubject<ClassesCollectionDetailAction> classesCollectionDetailActionPublishSubject;

    public ClassesCollectionDetailPresenterImpl(ClassesRepository classesRepository, AbilityRepository abilityRepository, FocusRepository focusRepository, DurationRepository durationRepository, Gson gson, PublishSubject<ClassesCollectionDetailAction> classesCollectionDetailActionPublishSubject) {
        this.classesRepository = classesRepository;
        this.abilityRepository = abilityRepository;
        this.focusRepository = focusRepository;
        this.durationRepository = durationRepository;
        this.gson = gson;
        this.classesCollectionDetailActionPublishSubject = classesCollectionDetailActionPublishSubject;
    }

    @Override
    public void getFiltersType(int type, int collectionId) {
        switch (type) {
            case Constant.TAB_ABILITY:
                getClassesAbility(collectionId);
                break;
            case Constant.TAB_FOCUS:
                getClassesFocus(collectionId);
                break;
            case Constant.TAB_DURATION:
            default:
                getClassesDuration(collectionId);
                break;
        }
    }

    private void getClassesDuration(int collectionId) {
        disposable.add(Observable.just(durationRepository.getAllDuration())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(durations -> {
                    List<FilterClasses> filterClassesList = new ArrayList<>();
                    for (Duration duration : durations) {
                        List<Classes> listClasses = classesRepository.getClassesByDurationId(collectionId, duration.getId());
                        if (listClasses != null && !listClasses.isEmpty()) {
                            filterClassesList.add(new FilterClasses(listClasses, duration.getNameEntity(gson).getNameLocale()));
                        }
                    }
                    classesCollectionDetailActionPublishSubject.onNext(ClassesCollectionDetailAction.setFilterClasses(filterClassesList));
                }));
    }

    private void getClassesFocus(int collectionId) {
        disposable.add(Observable.just(focusRepository.getAllFocus())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(focusList -> {
                    List<FilterClasses> filterClassesList = new ArrayList<>();
                    for (Focus focus : focusList) {
                        List<Classes> listClasses = classesRepository.getClassesByFocusId(collectionId, focus.getId());
                        if (listClasses != null && !listClasses.isEmpty()) {
                            filterClassesList.add(new FilterClasses(listClasses, focus.getNameEntity(gson).getNameLocale()));
                        }
                    }
                    classesCollectionDetailActionPublishSubject.onNext(ClassesCollectionDetailAction.setFilterClasses(filterClassesList));
                }));
    }

    private void getClassesAbility(int collectionId) {
        disposable.add(Observable.just(abilityRepository.getAllAbility())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(abilities -> {
                    List<FilterClasses> filterClassesList = new ArrayList<>();
                    for (Ability ability : abilities) {
                        List<Classes> listClasses = classesRepository.getClassesByAbilityId(collectionId, ability.getId());
                        if (listClasses != null && !listClasses.isEmpty()) {
                            filterClassesList.add(new FilterClasses(listClasses, ability.getNameEntity(gson).getNameLocale()));
                        }
                    }
                    classesCollectionDetailActionPublishSubject.onNext(ClassesCollectionDetailAction.setFilterClasses(filterClassesList));
                }));
    }
}
