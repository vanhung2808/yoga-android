package com.stdio.hue.yoga.data.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.stdio.hue.yoga.data.models.Ability;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Dao
public interface AbilityDao {
    @Query("SELECT * FROM ability")
    List<Ability> getAll();

    @Insert
    void insertAll(List<Ability> abilities);

    @Delete
    void delete(Ability ability);

    @Update
    void updateAbilities(List<Ability> abilities);
}
