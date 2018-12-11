package com.stdio.hue.yoga;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.multidex.MultiDexApplication;

import com.akexorcist.localizationactivity.core.LocalizationApplicationDelegate;
import com.downloader.PRDownloader;
import com.downloader.PRDownloaderConfig;
import com.stdio.hue.yoga.databases.AppDatabase;
import com.stdio.hue.yoga.di.components.AppComponent;
import com.stdio.hue.yoga.di.components.DaggerAppComponent;
import com.stdio.hue.yoga.services.DownloadService;

/**
 * Created by TranHuuPhuc on 7/6/18.
 */
public class ProjectApplication extends MultiDexApplication {

    private AppComponent appComponent;
    private LocalizationApplicationDelegate localizationDelegate = new LocalizationApplicationDelegate(this);

    @Override
    public void onCreate() {
        super.onCreate();
        Room.databaseBuilder(this, AppDatabase.class, "yogadb")
                .allowMainThreadQueries()
                .build();
        PRDownloaderConfig config = PRDownloaderConfig.newBuilder()
                .setDatabaseEnabled(true)
                .build();
        PRDownloader.initialize(getApplicationContext(), config);
        startService(new Intent(this, DownloadService.class));
        getAppComponent().inject(this);
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .context(this)
                    .build();
        }
        return appComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(localizationDelegate.attachBaseContext(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localizationDelegate.onConfigurationChanged(this);
    }

    @Override
    public Context getApplicationContext() {
        return localizationDelegate.getApplicationContext(super.getApplicationContext());
    }
}
