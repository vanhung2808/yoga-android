package com.stdio.hue.yoga.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stdio.hue.yoga.data.di.DataModule;
import com.stdio.hue.yoga.network.di.NetworkModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hung.nguyendk on 4/29/18.
 */
@Module(includes = {NetworkModule.class, DataModule.class})
@Singleton
public class AppModule {
    @Provides
    @Singleton
    @Named("default")
    public Gson providesGson() {
        return new GsonBuilder().create();
    }
}
