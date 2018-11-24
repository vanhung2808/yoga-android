package com.stdio.hue.yoga.modules.collections.presenter;

import com.stdio.hue.yoga.base.core.mvp.Presenter;

/**
 * Created by TranHuuPhuc on 11/23/18.
 */
public interface ClassesCollectionDetailPresenter extends Presenter {
    void getFiltersType(int type, int collectionId);
}
