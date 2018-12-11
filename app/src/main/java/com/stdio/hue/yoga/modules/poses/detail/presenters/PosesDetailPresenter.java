package com.stdio.hue.yoga.modules.poses.detail.presenters;

import com.stdio.hue.yoga.base.core.mvp.Presenter;
import com.stdio.hue.yoga.data.models.Poses;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by TranHuuPhuc on 12/10/18.
 */
public interface PosesDetailPresenter extends Presenter {
    Observable<List<String>> getData(String abilityId, String focusId);

    void updatePosesFavorite(Poses poses);
}
