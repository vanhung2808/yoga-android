package com.stdio.hue.yoga.modules.classes.detail.presenters;

import com.stdio.hue.yoga.base.core.mvp.Presenter;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by TranHuuPhuc on 12/4/18.
 */
public interface ClassesDetailPresenter extends Presenter {
    Observable<List<Object>> getData(int classesId, String abilityId, String intensityId, String focusId);
    String getCollectionNameById(int collectionId);
}
