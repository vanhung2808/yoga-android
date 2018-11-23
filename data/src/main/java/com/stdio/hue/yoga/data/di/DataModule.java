package com.stdio.hue.yoga.data.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
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
import com.stdio.hue.yoga.data.usecases.GetAbilitiesUseCase;
import com.stdio.hue.yoga.data.usecases.GetBannersUseCase;
import com.stdio.hue.yoga.data.usecases.GetCategoriesUseCase;
import com.stdio.hue.yoga.data.usecases.GetClassesUseCase;
import com.stdio.hue.yoga.data.usecases.GetCollectionsUseCase;
import com.stdio.hue.yoga.data.usecases.GetDurationsUseCase;
import com.stdio.hue.yoga.data.usecases.GetFocusUseCase;
import com.stdio.hue.yoga.data.usecases.GetIntensitiesUseCase;
import com.stdio.hue.yoga.data.usecases.GetPosesUseCase;
import com.stdio.hue.yoga.network.di.NetworkModule;
import com.stdio.hue.yoga.network.service.DataService;

import java.text.DateFormat;
import java.util.Date;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TranHuuPhuc on 7/6/18.
 */
@Module(includes = {NetworkModule.class, MapperModule.class})
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
                                                           AbilityMapper abilityMapper) {
        return new GetAbilitiesUseCase(gson, dataService, errorMapper, abilityMapper);
    }

    @Provides
    public GetBannersUseCase providesGetBannersUseCase(Gson gson,
                                                       DataService dataService,
                                                       ErrorMapper errorMapper,
                                                       BannerMapper abilityMapper) {
        return new GetBannersUseCase(gson, dataService, errorMapper, abilityMapper);
    }

    @Provides
    public GetCategoriesUseCase providesGetCategoriesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, CategoryMapper abilityMapper) {
        return new GetCategoriesUseCase(gson, dataService, errorMapper, abilityMapper);
    }

    @Provides
    public GetClassesUseCase providesGetClassesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, ClassesMapper abilityMapper) {
        return new GetClassesUseCase(gson, dataService, errorMapper, abilityMapper);
    }

    @Provides
    public GetCollectionsUseCase providesGetCollectionsUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, CollectionMapper abilityMapper) {
        return new GetCollectionsUseCase(gson, dataService, errorMapper, abilityMapper);
    }

    @Provides
    public GetDurationsUseCase providesGetDurationsUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, DurationMapper abilityMapper) {
        return new GetDurationsUseCase(gson, dataService, errorMapper, abilityMapper);
    }

    @Provides
    public GetFocusUseCase providesGetFocusUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, FocusMapper abilityMapper) {
        return new GetFocusUseCase(gson, dataService, errorMapper, abilityMapper);
    }

    @Provides
    public GetIntensitiesUseCase providesGetIntensitiesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, IntensityMapper abilityMapper) {
        return new GetIntensitiesUseCase(gson, dataService, errorMapper, abilityMapper);
    }

    @Provides
    public GetPosesUseCase providesGetPosesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, PosesMapper posesMapper) {
        return new GetPosesUseCase(gson, dataService, errorMapper, posesMapper);
    }
}
