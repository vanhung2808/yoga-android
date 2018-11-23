package com.stdio.hue.yoga.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.stdio.hue.yoga.data.models.Banner;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Dao
public interface BannerDao {
    @Query("SELECT * FROM banner")
    List<Banner> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertBanner(Banner banners);

    @Delete
    void delete(Banner banner);

    @Update
    void updateAllBanner(List<Banner> banners);
}
