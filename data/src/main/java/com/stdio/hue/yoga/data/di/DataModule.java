package com.stdio.hue.yoga.data.di;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.stdio.hue.yoga.data.databases.AppDatabase;
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
import com.stdio.hue.yoga.data.mappers.AbilityMapper;
import com.stdio.hue.yoga.data.mappers.BannerMapper;
import com.stdio.hue.yoga.data.mappers.CategoryMapper;
import com.stdio.hue.yoga.data.mappers.ClassesMapper;
import com.stdio.hue.yoga.data.mappers.CollectionMapper;
import com.stdio.hue.yoga.data.mappers.DurationMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.mappers.FocusMapper;
import com.stdio.hue.yoga.data.mappers.IntensityMapper;
import com.stdio.hue.yoga.data.mappers.PosesMapper;
import com.stdio.hue.yoga.data.usecases.locals.GetAllBannerLocalUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetAbilitiesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetBannersUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetCategoriesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetClassesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetCollectionsUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetDurationsUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetFocusUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetIntensitiesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetPosesUseCase;
import com.stdio.hue.yoga.network.di.NetworkModule;
import com.stdio.hue.yoga.network.service.DataService;

import java.text.DateFormat;
import java.util.Date;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TranHuuPhuc on 7/6/18.
 */
@Module(includes = {NetworkModule.class, MapperModule.class, RepositoryModule.class})
public class DataModule {
    @Provides
    public Gson providesGson() {
        GsonBuilder builder = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, context) -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()))
                .enableComplexMapKeySerialization()
                .serializeNulls()
                .setDateFormat(DateFormat.LONG);
        return builder.create();
    }

    //Use Case Server
    @Provides
    public GetAbilitiesUseCase providesGetAbilitiesUseCase(Gson gson,
                                                           DataService dataService,
                                                           ErrorMapper errorMapper,
                                                           AbilityMapper abilityMapper,
                                                           AbilityRepository abilityRepository) {
        return new GetAbilitiesUseCase(gson, dataService, errorMapper, abilityMapper, abilityRepository);
    }

    @Provides
    public GetBannersUseCase providesGetBannersUseCase(Gson gson,
                                                       DataService dataService,
                                                       ErrorMapper errorMapper,
                                                       BannerMapper abilityMapper,
                                                       BannerRepository abilityRepository) {
        return new GetBannersUseCase(gson, dataService, errorMapper, abilityMapper, abilityRepository);
    }

    @Provides
    public GetCategoriesUseCase providesGetCategoriesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, CategoryMapper abilityMapper, CategoryRepository abilityRepository) {
        return new GetCategoriesUseCase(gson, dataService, errorMapper, abilityMapper, abilityRepository);
    }

    @Provides
    public GetClassesUseCase providesGetClassesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, ClassesMapper abilityMapper, ClassesRepository abilityRepository) {
        return new GetClassesUseCase(gson, dataService, errorMapper, abilityMapper, abilityRepository);
    }

    @Provides
    public GetCollectionsUseCase providesGetCollectionsUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, CollectionMapper abilityMapper, CollectionRepository abilityRepository) {
        return new GetCollectionsUseCase(gson, dataService, errorMapper, abilityMapper, abilityRepository);
    }

    @Provides
    public GetDurationsUseCase providesGetDurationsUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, DurationMapper abilityMapper, DurationRepository abilityRepository) {
        return new GetDurationsUseCase(gson, dataService, errorMapper, abilityMapper, abilityRepository);
    }

    @Provides
    public GetFocusUseCase providesGetFocusUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, FocusMapper abilityMapper, FocusRepository abilityRepository) {
        return new GetFocusUseCase(gson, dataService, errorMapper, abilityMapper, abilityRepository);
    }

    @Provides
    public GetIntensitiesUseCase providesGetIntensitiesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, IntensityMapper abilityMapper, IntensityRepository abilityRepository) {
        return new GetIntensitiesUseCase(gson, dataService, errorMapper, abilityMapper, abilityRepository);
    }

    @Provides
    public GetPosesUseCase providesGetPosesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, PosesMapper posesMapper, PosesRepository posesRepository) {
        return new GetPosesUseCase(gson, dataService, errorMapper, posesMapper, posesRepository);
    }

    //DAO
    @Provides
    AbilityDao providesAbilityDao(Context context) {
        return AppDatabase.getInstance(context).abilityDao();
    }

    @Provides
    BannerDao providesBannerDao(Context context) {
        return AppDatabase.getInstance(context).bannerDao();
    }

    @Provides
    CategoryDao providesCategoryDao(Context context) {
        return AppDatabase.getInstance(context).categoryDao();
    }

    @Provides
    ClassesDao providesClassesDao(Context context) {
        return AppDatabase.getInstance(context).classesDao();
    }

    @Provides
    CollectionDao providesCollectionDao(Context context) {
        return AppDatabase.getInstance(context).collectionDao();
    }

    @Provides
    DurationDao providesDurationDao(Context context) {
        return AppDatabase.getInstance(context).durationDao();
    }

    @Provides
    FocusDao providesFocusDao(Context context) {
        return AppDatabase.getInstance(context).focusDao();
    }

    @Provides
    IntensityDao providesIntensityDao(Context context) {
        return AppDatabase.getInstance(context).intensityDao();
    }

    @Provides
    PosesDao providesPosesDao(Context context) {
        return AppDatabase.getInstance(context).posesDao();
    }

    //Use Case Local Database
    @Provides
    public GetAllBannerLocalUseCase providesGetAllBannerLocalUseCase(Gson gson, BannerRepository bannerRepository) {
        return new GetAllBannerLocalUseCase(gson, bannerRepository);
    }

}
