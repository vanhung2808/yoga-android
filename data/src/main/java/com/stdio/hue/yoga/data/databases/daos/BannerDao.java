package com.stdio.hue.yoga.data.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.stdio.hue.yoga.data.models.Banner;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Dao
public interface BannerDao {
    @Query("SELECT * FROM banner")
    Flowable<List<Banner>> getAll();

    @Insert
    void insertAll(List<Banner> banners);

    @Delete
    void delete(Banner banner);

    @Update
    void updateAllBanner(List<Banner> banners);
}
