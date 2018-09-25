package com.stdio.hue.yoga.data.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.stdio.hue.yoga.data.usecases.GetBannersUseCase;
import com.stdio.hue.yoga.network.di.NetworkModule;
import com.stdio.hue.yoga.network.service.BannerService;

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
}
