package com.stdio.hue.yoga;

import android.arch.persistence.room.Room;
import android.support.multidex.MultiDexApplication;

import com.stdio.hue.yoga.databases.AppDatabase;
import com.stdio.hue.yoga.di.components.AppComponent;
import com.stdio.hue.yoga.di.components.DaggerAppComponent;

/**
 * Created by TranHuuPhuc on 7/6/18.
 */
public class ProjectApplication extends MultiDexApplication {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Room.databaseBuilder(this, AppDatabase.class, "yogadb")
                .allowMainThreadQueries()
                .build();
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
}
