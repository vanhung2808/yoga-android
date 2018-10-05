package com.stdio.hue.yoga.data.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.stdio.hue.yoga.data.usecases.GetAllCategoryUseCase;
import com.stdio.hue.yoga.data.usecases.GetBannersUseCase;
import com.stdio.hue.yoga.data.usecases.GetCategoryDetailUseCase;
import com.stdio.hue.yoga.data.usecases.GetClassDetailUseCase;
import com.stdio.hue.yoga.data.usecases.GetClassesOfCollectionUseCase;
import com.stdio.hue.yoga.data.usecases.GetCollectionDetailUseCase;
import com.stdio.hue.yoga.data.usecases.GetCollectionOfCategoryUseCase;
import com.stdio.hue.yoga.network.di.NetworkModule;
import com.stdio.hue.yoga.network.service.BannerService;
import com.stdio.hue.yoga.network.service.CategoryService;
import com.stdio.hue.yoga.network.service.ClassService;
import com.stdio.hue.yoga.network.service.CollectionService;

import java.text.DateFormat;
import java.util.Date;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TranHuuPhuc on 7/6/18.
 */
@Module(includes = {NetworkModule.class})
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

    @Provides
    GetBannersUseCase providesGetBannersUseCase(Gson gson, BannerService bannerService) {
        return new GetBannersUseCase(gson, bannerService);
    }

    @Provides
    GetAllCategoryUseCase providesGetAllCategoryUseCase(Gson gson, CategoryService categoryService) {
        return new GetAllCategoryUseCase(gson, categoryService);
    }

    @Provides
    GetCategoryDetailUseCase providesGetCategoryDetailUseCase(Gson gson, CategoryService categoryService) {
        return new GetCategoryDetailUseCase(gson, categoryService);
    }

    @Provides
    GetClassDetailUseCase providesGetClassDetailUseCase(Gson gson, ClassService classService) {
        return new GetClassDetailUseCase(gson, classService);
    }

    @Provides
    GetClassesOfCollectionUseCase providesGetClassesOfCollectionUseCase(Gson gson, ClassService classService) {
        return new GetClassesOfCollectionUseCase(gson, classService);
    }

    @Provides
    GetCollectionDetailUseCase providesGetCollectionDetailUseCase(Gson gson, CollectionService collectionService) {
        return new GetCollectionDetailUseCase(gson, collectionService);
    }

    @Provides
    GetCollectionOfCategoryUseCase providesGetCollectionOfCategoryUseCase(Gson gson, CollectionService collectionService) {
        return new GetCollectionOfCategoryUseCase(gson, collectionService);
    }
}
