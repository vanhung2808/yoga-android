package com.stdio.hue.yoga.di.modules;

import android.content.Context;

import com.stdio.hue.yoga.databases.AppDatabase;
import com.stdio.hue.yoga.databases.daos.AbilityDao;
import com.stdio.hue.yoga.databases.daos.BannerDao;
import com.stdio.hue.yoga.databases.daos.CategoryDao;
import com.stdio.hue.yoga.databases.daos.ClassesDao;
import com.stdio.hue.yoga.databases.daos.CollectionDao;
import com.stdio.hue.yoga.databases.daos.DurationDao;
import com.stdio.hue.yoga.databases.daos.FocusDao;
import com.stdio.hue.yoga.databases.daos.IntensityDao;
import com.stdio.hue.yoga.databases.daos.PosesDao;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
@Module
public class DaoModule {
    //DAO
    @Provides
    AbilityDao providesAbilityDao(@Named("application") Context context) {
        return AppDatabase.getInstance(context).abilityDao();
    }

    @Provides
    BannerDao providesBannerDao(@Named("application") Context context) {
        return AppDatabase.getInstance(context).bannerDao();
    }

    @Provides
    CategoryDao providesCategoryDao(@Named("application") Context context) {
        return AppDatabase.getInstance(context).categoryDao();
    }

    @Provides
    ClassesDao providesClassesDao(@Named("application") Context context) {
        return AppDatabase.getInstance(context).classesDao();
    }

    @Provides
    CollectionDao providesCollectionDao(@Named("application") Context context) {
        return AppDatabase.getInstance(context).collectionDao();
    }

    @Provides
    DurationDao providesDurationDao(@Named("application") Context context) {
        return AppDatabase.getInstance(context).durationDao();
    }

    @Provides
    FocusDao providesFocusDao(@Named("application") Context context) {
        return AppDatabase.getInstance(context).focusDao();
    }

    @Provides
    IntensityDao providesIntensityDao(@Named("application") Context context) {
        return AppDatabase.getInstance(context).intensityDao();
    }

    @Provides
    PosesDao providesPosesDao(@Named("application") Context context) {
        return AppDatabase.getInstance(context).posesDao();
    }

}
