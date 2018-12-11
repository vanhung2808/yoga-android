package com.stdio.hue.yoga.modules.poses.detail.di;

import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.databases.repositories.PosesRepository;
import com.stdio.hue.yoga.modules.poses.detail.presenters.PosesDetailPresenter;
import com.stdio.hue.yoga.modules.poses.detail.presenters.PosesDetailPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TranHuuPhuc on 12/10/18.
 */
@Module
public class PosesDetailModule {
    @Provides
    public PosesDetailPresenter providesPosesDetailPresenter(AbilityRepository abilityRepository, FocusRepository focusRepository, PosesRepository posesRepository) {
        return new PosesDetailPresenterImpl(abilityRepository, focusRepository, posesRepository);
    }

}
