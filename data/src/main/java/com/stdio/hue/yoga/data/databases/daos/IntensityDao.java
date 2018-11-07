package com.stdio.hue.yoga.data.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.stdio.hue.yoga.data.models.Intensity;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Dao
public interface IntensityDao {
    @Query("SELECT * FROM intensity")
    List<Intensity> getAll();

    @Insert
    void insertAll(List<Intensity> intensities);

    @Delete
    void delete(Intensity intensity);

    @Update
    void updateAllIntensity(Intensity... intensities);
}
