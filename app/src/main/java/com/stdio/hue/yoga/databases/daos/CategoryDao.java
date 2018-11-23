package com.stdio.hue.yoga.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.stdio.hue.yoga.data.models.Category;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Dao
public interface CategoryDao {
    @Query("SELECT * FROM category")
    List<Category> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(Category category);

    @Delete
    void delete(Category category);

    @Update
    void updateAllCategory(List<Category> categories);
}
