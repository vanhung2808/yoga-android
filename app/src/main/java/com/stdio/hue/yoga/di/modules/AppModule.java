package com.stdio.hue.yoga.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stdio.hue.yoga.data.di.DataModule;
import com.stdio.hue.yoga.data.di.MapperModule;
import com.stdio.hue.yoga.data.di.RepositoryModule;
import com.stdio.hue.yoga.network.di.NetworkModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hung.nguyendk on 4/29/18.
 */
@Module(includes = {NetworkModule.class, DataModule.class, MapperModule.class, RepositoryModule.class})
@Singleton
public class AppModule {
    @Provides
    @Singleton
    @Named("default")
    public Gson providesGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    @Named("setting")
    public SharedPreferences providesSettingSharedPreferences(Context context) {
        return context.getSharedPreferences("setting", Context.MODE_PRIVATE);
    }
}
