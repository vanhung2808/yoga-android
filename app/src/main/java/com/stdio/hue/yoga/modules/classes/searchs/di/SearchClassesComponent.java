package com.stdio.hue.yoga.modules.classes.searchs.di;

import com.stdio.hue.yoga.modules.classes.searchs.presenters.SearchClassesPresenter;
import com.stdio.hue.yoga.modules.classes.searchs.ui.actions.SearchClassesAction;

import dagger.Subcomponent;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 11/24/18.
 */
@Subcomponent(modules = SearchClassesModule.class)
public interface SearchClassesComponent {
    SearchClassesPresenter getSearchClassesPresenter();

    PublishSubject<SearchClassesAction> getSearchClassesAction();
}
