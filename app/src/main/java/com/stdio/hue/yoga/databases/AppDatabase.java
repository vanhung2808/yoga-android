package com.stdio.hue.yoga.databases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.stdio.hue.yoga.data.models.Ability;
import com.stdio.hue.yoga.data.models.Banner;
import com.stdio.hue.yoga.data.models.Category;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.data.models.Duration;
import com.stdio.hue.yoga.data.models.Focus;
import com.stdio.hue.yoga.data.models.Intensity;
import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.data.models.PosesType;
import com.stdio.hue.yoga.databases.daos.AbilityDao;
import com.stdio.hue.yoga.databases.daos.BannerDao;
import com.stdio.hue.yoga.databases.daos.CategoryDao;
import com.stdio.hue.yoga.databases.daos.ClassesDao;
import com.stdio.hue.yoga.databases.daos.CollectionDao;
import com.stdio.hue.yoga.databases.daos.DurationDao;
import com.stdio.hue.yoga.databases.daos.FocusDao;
import com.stdio.hue.yoga.databases.daos.IntensityDao;
import com.stdio.hue.yoga.databases.daos.NewsDao;
import com.stdio.hue.yoga.databases.daos.PosesDao;
import com.stdio.hue.yoga.modules.auth.dao.UserDao;
import com.stdio.hue.yoga.modules.auth.model.User;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Database(entities = {Ability.class, Banner.class, Category.class, Classes.class, Collection.class, Duration.class, Focus.class, Intensity.class, Poses.class, PosesType.class, News.class, User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room
                    .databaseBuilder(context.getApplicationContext(), AppDatabase.class, "yogadb")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract AbilityDao abilityDao();

    public abstract BannerDao bannerDao();

    public abstract CategoryDao categoryDao();

    public abstract ClassesDao classesDao();

    public abstract CollectionDao collectionDao();

    public abstract DurationDao durationDao();

    public abstract FocusDao focusDao();

    public abstract IntensityDao intensityDao();

    public abstract PosesDao posesDao();

    public abstract NewsDao newsDao();

    public abstract UserDao userDao();
}
