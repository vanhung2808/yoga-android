package com.stdio.hue.yoga.modules.poses.detail.presenters;

import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.databases.repositories.PosesRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 12/10/18.
 */
public class PosesDetailPresenterImpl extends BasePresenter implements PosesDetailPresenter {
    private AbilityRepository abilityRepository;
    private FocusRepository focusRepository;
    private PosesRepository posesRepository;

    public PosesDetailPresenterImpl(AbilityRepository abilityRepository, FocusRepository focusRepository, PosesRepository posesRepository) {
        this.abilityRepository = abilityRepository;
        this.focusRepository = focusRepository;
        this.posesRepository = posesRepository;
    }

    @Override
    public Observable<List<String>> getData(String abilityId, String focusId) {
        return Observable.combineLatest(
                getAbilityName(abilityId),
                getFocusName(focusId),
                (ability, focus) -> {
                    List<String> list = new ArrayList<>();
                    list.add(ability);
                    list.add(focus);
                    return list;
                })
                .subscribeOn(Schedulers.io())
                .map(results -> results);
    }

    @Override
    public void updatePosesFavorite(Poses poses) {
        posesRepository.updatePoses(poses);
    }

    private Observable<String> getFocusName(String focusId) {
        return Observable.just(focusRepository.getFocusName(focusId));
    }

    private Observable<String> getAbilityName(String abilityId) {
        return Observable.just(abilityRepository.getAbilityName(abilityId));
    }
}
