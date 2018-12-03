package com.stdio.hue.yoga.modules.splash.di;

import com.stdio.hue.yoga.data.usecases.GetAbilitiesUseCase;
import com.stdio.hue.yoga.data.usecases.GetBannersUseCase;
import com.stdio.hue.yoga.data.usecases.GetCategoriesUseCase;
import com.stdio.hue.yoga.data.usecases.GetClassesUseCase;
import com.stdio.hue.yoga.data.usecases.GetCollectionsUseCase;
import com.stdio.hue.yoga.data.usecases.GetDurationsUseCase;
import com.stdio.hue.yoga.data.usecases.GetFocusUseCase;
import com.stdio.hue.yoga.data.usecases.GetIntensitiesUseCase;
import com.stdio.hue.yoga.data.usecases.GetNewsUseCase;
import com.stdio.hue.yoga.data.usecases.GetPosesUseCase;
import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.databases.repositories.CategoryRepository;
import com.stdio.hue.yoga.databases.repositories.ClassesRepository;
import com.stdio.hue.yoga.databases.repositories.CollectionRepository;
import com.stdio.hue.yoga.databases.repositories.DurationRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.databases.repositories.IntensityRepository;
import com.stdio.hue.yoga.databases.repositories.NewsRepository;
import com.stdio.hue.yoga.databases.repositories.PosesRepository;
import com.stdio.hue.yoga.modules.splash.presenter.SplashPresenter;
import com.stdio.hue.yoga.modules.splash.presenter.SplashPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hung.nguyendk on 4/29/18.
 */
@Module
public class SplashModule {
    @Provides
    public SplashPresenter providesSplashPresenter(GetAbilitiesUseCase getAbilitiesUseCase, GetBannersUseCase getBannersUseCase, GetCategoriesUseCase getCategoriesUseCase, GetClassesUseCase getClassesUseCase, GetCollectionsUseCase getCollectionsUseCase, GetDurationsUseCase getDurationsUseCase, GetFocusUseCase getFocusUseCase, GetIntensitiesUseCase getIntensitiesUseCase, GetPosesUseCase getPosesUseCase, GetNewsUseCase getNewsUseCase, BannerRepository bannerRepository, AbilityRepository abilityRepository, CategoryRepository categoryRepository, ClassesRepository classesRepository, CollectionRepository collectionRepository, DurationRepository durationRepository, FocusRepository focusRepository, IntensityRepository intensityRepository, PosesRepository posesRepository, NewsRepository newsRepository) {
        return new SplashPresenterImpl(getAbilitiesUseCase, getBannersUseCase, getCategoriesUseCase, getClassesUseCase, getCollectionsUseCase, getDurationsUseCase, getFocusUseCase, getIntensitiesUseCase, getPosesUseCase, getNewsUseCase, bannerRepository, abilityRepository, categoryRepository, classesRepository, collectionRepository, durationRepository, focusRepository, intensityRepository, posesRepository, newsRepository);
    }
}
