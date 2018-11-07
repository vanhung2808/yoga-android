package com.stdio.hue.yoga.data.di;

import com.stdio.hue.yoga.data.databases.daos.AbilityDao;
import com.stdio.hue.yoga.data.databases.daos.BannerDao;
import com.stdio.hue.yoga.data.databases.daos.CategoryDao;
import com.stdio.hue.yoga.data.databases.daos.ClassesDao;
import com.stdio.hue.yoga.data.databases.daos.CollectionDao;
import com.stdio.hue.yoga.data.databases.daos.DurationDao;
import com.stdio.hue.yoga.data.databases.daos.FocusDao;
import com.stdio.hue.yoga.data.databases.daos.IntensityDao;
import com.stdio.hue.yoga.data.databases.daos.PosesDao;
import com.stdio.hue.yoga.data.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.data.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.data.databases.repositories.CategoryRepository;
import com.stdio.hue.yoga.data.databases.repositories.ClassesRepository;
import com.stdio.hue.yoga.data.databases.repositories.CollectionRepository;
import com.stdio.hue.yoga.data.databases.repositories.DurationRepository;
import com.stdio.hue.yoga.data.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.data.databases.repositories.IntensityRepository;
import com.stdio.hue.yoga.data.databases.repositories.PosesRepository;
import com.stdio.hue.yoga.data.databases.repositories.impl.AbilityRepositoryImpl;
import com.stdio.hue.yoga.data.databases.repositories.impl.BannerRepositoryImpl;
import com.stdio.hue.yoga.data.databases.repositories.impl.CategoryRepositoryImpl;
import com.stdio.hue.yoga.data.databases.repositories.impl.ClassesRepositoryImpl;
import com.stdio.hue.yoga.data.databases.repositories.impl.CollectionRepositoryImpl;
import com.stdio.hue.yoga.data.databases.repositories.impl.DurationRepositoryImpl;
import com.stdio.hue.yoga.data.databases.repositories.impl.FocusRepositoryImpl;
import com.stdio.hue.yoga.data.databases.repositories.impl.IntensityRepositoryImpl;
import com.stdio.hue.yoga.data.databases.repositories.impl.PosesRepositoryImpl;

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
    public BannerRepository providesBannerRepository(BannerDao bannerDao) {
        return new BannerRepositoryImpl(bannerDao);
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
