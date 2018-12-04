package com.stdio.hue.yoga.modules.classes.detail.di;

import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.databases.repositories.IntensityRepository;
import com.stdio.hue.yoga.databases.repositories.PosesRepository;
import com.stdio.hue.yoga.modules.classes.detail.presenters.ClassesDetailPresenter;
import com.stdio.hue.yoga.modules.classes.detail.presenters.ClassesDetailPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TranHuuPhuc on 12/4/18.
 */
@Module
public class ClassesDetailModule {
    @Provides
    public ClassesDetailPresenter providesClassesDetailPresenter(AbilityRepository abilityRepository, FocusRepository focusRepository, IntensityRepository intensityRepository, PosesRepository posesRepository) {
        return new ClassesDetailPresenterImpl(abilityRepository, focusRepository, intensityRepository, posesRepository);
    }
}
