package com.stdio.hue.yoga.data.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.stdio.hue.yoga.data.models.Classes;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Dao
public interface ClassesDao {
    @Query("SELECT * FROM classes")
    List<Classes> getAll();

    @Insert
    void insertAll(List<Classes> classes);

    @Delete
    void delete(Classes classes);

    @Update
    void updateAllClasses(List<Classes> classes);
}
