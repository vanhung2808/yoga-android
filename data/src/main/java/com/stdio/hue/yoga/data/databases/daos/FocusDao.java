package com.stdio.hue.yoga.data.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.stdio.hue.yoga.data.models.Focus;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Dao
public interface FocusDao {
    @Query("SELECT * FROM focus")
    List<Focus> getAll();

    @Insert
    void insertAll(List<Focus> focus);

    @Delete
    void delete(Focus focus);

    @Update
    void updateAllFocus(Focus... focus);
}
