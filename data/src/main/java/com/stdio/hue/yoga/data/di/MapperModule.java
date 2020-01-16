package com.stdio.hue.yoga.data.di;

import com.stdio.hue.yoga.data.mappers.AbilityMapper;
import com.stdio.hue.yoga.data.mappers.BannerMapper;
import com.stdio.hue.yoga.data.mappers.CategoryMapper;
import com.stdio.hue.yoga.data.mappers.ClassesMapper;
import com.stdio.hue.yoga.data.mappers.CollectionMapper;
import com.stdio.hue.yoga.data.mappers.DurationMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.mappers.FocusMapper;
import com.stdio.hue.yoga.data.mappers.IntensityMapper;
import com.stdio.hue.yoga.data.mappers.NewsMapper;
import com.stdio.hue.yoga.data.mappers.PosesMapper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TranHuuPhuc on 10/21/18.
 */
@Module
public class MapperModule {
    @Provides
    ErrorMapper providesErrorMapper() {
        return new ErrorMapper();
    }

    @Provides
    AbilityMapper providesAbilityMapper() {
        return new AbilityMapper();
    }

    @Provides
    BannerMapper providesBannerMapper() {
        return new BannerMapper();
    }

    @Provides
    CategoryMapper providesCategoryMapper() {
        return new CategoryMapper();
    }

    @Provides
    ClassesMapper providesClassesMapper() {
        return new ClassesMapper();
    }

    @Provides
    CollectionMapper providesCollectionMapper() {
        return new CollectionMapper();
    }

    @Provides
    DurationMapper providesDurationMapper() {
        return new DurationMapper();
    }

    @Provides
    FocusMapper providesFocusMapper() {
        return new FocusMapper();
    }

    @Provides
    IntensityMapper providesIntensityMapper() {
        return new IntensityMapper();
    }

    @Provides
    PosesMapper providesPosesMapper() {
        return new PosesMapper();
    }

    @Provides
    NewsMapper provideNewsMapper(){
        return new NewsMapper();
    }
}
