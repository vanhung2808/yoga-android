package com.stdio.hue.yoga.modules.classes.searchs.di;

import com.google.gson.Gson;
import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.ClassesRepository;
import com.stdio.hue.yoga.databases.repositories.DurationRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.databases.repositories.IntensityRepository;
import com.stdio.hue.yoga.modules.classes.searchs.presenters.SearchClassesPresenter;
import com.stdio.hue.yoga.modules.classes.searchs.presenters.impl.SearchClassesPresenterImpl;
import com.stdio.hue.yoga.modules.classes.searchs.ui.actions.SearchClassesAction;

import dagger.Module;
import dagger.Provides;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 11/24/18.
 */
@Module
public class SearchClassesModule {
    @Provides
    public SearchClassesPresenter providesSearchClassesPresenter(PublishSubject<SearchClassesAction> searchClassesActionPublishSubject, AbilityRepository abilityRepository, FocusRepository focusRepository, DurationRepository durationRepository, IntensityRepository intensityRepository, Gson gson, ClassesRepository classesRepository) {
        return new SearchClassesPresenterImpl(searchClassesActionPublishSubject, abilityRepository, focusRepository, durationRepository, intensityRepository, classesRepository, gson);
    }

    @Provides
    public PublishSubject<SearchClassesAction> providesSearchClassesAction() {
        return SearchClassesAction.publisher;
    }
}
