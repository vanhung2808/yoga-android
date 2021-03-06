package com.stdio.hue.yoga.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.stdio.hue.yoga.data.models.Duration;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Dao
public interface DurationDao {
    @Query("SELECT * FROM duration")
    List<Duration> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDuration(Duration duration);

    @Delete
    void delete(Duration duration);

    @Update
    void updateAllDuration(Duration... durations);
}
