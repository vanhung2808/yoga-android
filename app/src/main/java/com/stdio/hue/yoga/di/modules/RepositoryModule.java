package com.stdio.hue.yoga.di.modules;

import com.stdio.hue.yoga.databases.daos.AbilityDao;
import com.stdio.hue.yoga.databases.daos.BannerDao;
import com.stdio.hue.yoga.databases.daos.CategoryDao;
import com.stdio.hue.yoga.databases.daos.ClassesDao;
import com.stdio.hue.yoga.databases.daos.CollectionDao;
import com.stdio.hue.yoga.databases.daos.DurationDao;
import com.stdio.hue.yoga.databases.daos.FocusDao;
import com.stdio.hue.yoga.databases.daos.IntensityDao;
import com.stdio.hue.yoga.databases.daos.PosesDao;
import com.stdio.hue.yoga.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.databases.repositories.CategoryRepository;
import com.stdio.hue.yoga.databases.repositories.ClassesRepository;
import com.stdio.hue.yoga.databases.repositories.CollectionRepository;
import com.stdio.hue.yoga.databases.repositories.DurationRepository;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.databases.repositories.IntensityRepository;
import com.stdio.hue.yoga.databases.repositories.PosesRepository;
import com.stdio.hue.yoga.databases.repositories.impl.AbilityRepositoryImpl;
import com.stdio.hue.yoga.databases.repositories.impl.BannerRepositoryImpl;
import com.stdio.hue.yoga.databases.repositories.impl.CategoryRepositoryImpl;
import com.stdio.hue.yoga.databases.repositories.impl.ClassesRepositoryImpl;
import com.stdio.hue.yoga.databases.repositories.impl.CollectionRepositoryImpl;
import com.stdio.hue.yoga.databases.repositories.impl.DurationRepositoryImpl;
import com.stdio.hue.yoga.databases.repositories.impl.FocusRepositoryImpl;
import com.stdio.hue.yoga.databases.repositories.impl.IntensityRepositoryImpl;
import com.stdio.hue.yoga.databases.repositories.impl.PosesRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Module
public class RepositoryModule {
    @Provides
    public AbilityRepository providesAbilityRepository(AbilityDao abilityDao) {
        return new AbilityRepositoryImpl(abilityDao);
    }

    @Provides
    public BannerRepository providesBannerRepository(BannerDao bannerDao, CollectionDao collectionDao) {
        return new BannerRepositoryImpl(bannerDao, collectionDao);
    }

    @Provides
    public CategoryRepository providesCategoryRepository(CategoryDao categoryDao) {
        return new CategoryRepositoryImpl(categoryDao);
    }

    @Provides
    public ClassesRepository providesClassesRepository(ClassesDao classesDao) {
        return new ClassesRepositoryImpl(classesDao);
    }

    @Provides
    public CollectionRepository providesCollectionRepository(CollectionDao collectionDao) {
        return new CollectionRepositoryImpl(collectionDao);
    }

    @Provides
    public DurationRepository providesDurationRepository(DurationDao durationDao) {
        return new DurationRepositoryImpl(durationDao);
    }

    @Provides
    public FocusRepository providesFocusRepository(FocusDao focusDao) {
        return new FocusRepositoryImpl(focusDao);
    }

    @Provides
    public IntensityRepository providesIntensityRepository(IntensityDao intensityDao) {
        return new IntensityRepositoryImpl(intensityDao);
    }

    @Provides
    public PosesRepository providesPosesRepository(PosesDao posesDao) {
        return new PosesRepositoryImpl(posesDao);
    }
}
