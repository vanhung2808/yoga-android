package com.stdio.hue.yoga.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.data.models.Poses;

import java.util.List;

/**
 * Created by DucPham on 28/11/2018.
 */
@Dao
public interface NewsDao {
    @Query("SELECT * FROM news")
    List<News> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNews(News news);

    @Delete
    void delete(News news);

    @Update
    void updateAllNews(List<News> news);

    @Update
    void updateNews(News news);
}

