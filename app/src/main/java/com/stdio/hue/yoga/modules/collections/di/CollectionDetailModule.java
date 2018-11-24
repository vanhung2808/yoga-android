package com.stdio.hue.yoga.modules.collections.di;

import com.google.gson.Gson;
import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.ClassesRepository;
import com.stdio.hue.yoga.databases.repositories.DurationRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.modules.collections.presenter.ClassesCollectionDetailPresenter;
import com.stdio.hue.yoga.modules.collections.presenter.ClassesCollectionDetailPresenterImpl;
import com.stdio.hue.yoga.modules.collections.ui.actions.ClassesCollectionDetailAction;

import dagger.Module;
import dagger.Provides;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 11/23/18.
 */
@Module
public class CollectionDetailModule {
    @Provides
    public ClassesCollectionDetailPresenter providesClassesCollectionDetailPresenter(ClassesRepository classesRepository, AbilityRepository abilityRepository, FocusRepository focusRepository, DurationRepository durationRepository, Gson gson, PublishSubject<ClassesCollectionDetailAction> classesCollectionDetailActionPublishSubject) {
        return new ClassesCollectionDetailPresenterImpl(classesRepository, abilityRepository, focusRepository, durationRepository, gson, classesCollectionDetailActionPublishSubject);
    }

    @Provides
    public PublishSubject<ClassesCollectionDetailAction> providesClassesCollectionDetailAction() {
        return ClassesCollectionDetailAction.publisher;
    }
}
