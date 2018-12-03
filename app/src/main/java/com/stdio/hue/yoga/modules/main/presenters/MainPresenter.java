package com.stdio.hue.yoga.modules.main.presenters;

import com.stdio.hue.yoga.base.core.mvp.Presenter;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public interface MainPresenter extends Presenter {
    void getBanners();

    void getAllCategories();

    void getCollectionsOfACategory(int categoryId);

    void getAllNews();
}
