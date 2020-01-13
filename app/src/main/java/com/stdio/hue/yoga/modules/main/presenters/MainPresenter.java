package com.stdio.hue.yoga.modules.main.presenters;

import com.stdio.hue.yoga.base.core.mvp.Presenter;
import com.stdio.hue.yoga.data.models.Collection;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public interface MainPresenter extends Presenter {
    void getBanners();

    void getAllCategories();

    Observable<List<Collection>> getCollectionsOfACategory(int categoryId);

    void getAllNews();

    void getAllPoses();
}
