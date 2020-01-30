package com.stdio.hue.yoga.modules.classes.detail.presenters;

import com.google.gson.Gson;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.databases.daos.CollectionDao;
import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.databases.repositories.IntensityRepository;
import com.stdio.hue.yoga.databases.repositories.PosesRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 12/4/18.
 */
public class ClassesDetailPresenterImpl extends BasePresenter implements ClassesDetailPresenter {
    private AbilityRepository abilityRepository;
    private FocusRepository focusRepository;
    private IntensityRepository intensityRepository;
    private PosesRepository posesRepository;
    private CollectionDao collectionDao;
    private Gson gson;

    public ClassesDetailPresenterImpl(
            AbilityRepository abilityRepository,
            FocusRepository focusRepository,
            IntensityRepository intensityRepository,
            PosesRepository posesRepository,
            CollectionDao collectionDao,
            Gson gson) {
        this.abilityRepository = abilityRepository;
        this.focusRepository = focusRepository;
        this.intensityRepository = intensityRepository;
        this.posesRepository = posesRepository;
        this.collectionDao = collectionDao;
        this.gson = gson;
    }

    @Override
    public Observable<List<Object>> getData(int classesId, String abilityId, String intensityId, String focusId) {
        return Observable.combineLatest(
                getAbilityName(abilityId),
                getIntensityName(intensityId),
                getFocusName(focusId),
                getPosesOfClasses(classesId),
                (ability, intensity, focus, posesList) -> {
                    List<Object> list = new ArrayList<>();
                    list.add(ability);
                    list.add(intensity);
                    list.add(focus);
                    list.add(posesList);
                    return list;
                })
                .subscribeOn(Schedulers.io())
                .map(results -> results);
    }

    @Override
    public String getCollectionNameById(int collectionId) {
        return collectionDao.getCollection(collectionId).getNameEntity(gson).getNameLocale();
    }

    private Observable<List<Poses>> getPosesOfClasses(int classesId) {
        return Observable.just(posesRepository.getPosesOfClasses(classesId));
    }

    private Observable<String> getFocusName(String focusId) {
        return Observable.just(focusRepository.getFocusName(focusId));
    }

    private Observable<String> getIntensityName(String intensityId) {
        return Observable.just(intensityRepository.getIntensityName(intensityId));
    }

    private Observable<String> getAbilityName(String abilityId) {
        return Observable.just(abilityRepository.getAbilityName(abilityId));
    }
}
