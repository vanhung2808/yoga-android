package com.stdio.hue.yoga.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertClasses(Classes classes);

    @Delete
    void delete(Classes classes);

    @Update
    void updateAllClasses(List<Classes> classes);

    @Query("SELECT COUNT(*) FROM classes WHERE classes.collection_id = :collectionId")
    int countClassesOfCollection(int collectionId);

    @Query("SELECT * FROM classes WHERE classes.collection_id = :collectionId AND classes.ability_id = :id")
    List<Classes> getClassesByAbilityId(int collectionId, int id);

    @Query("SELECT * FROM classes WHERE classes.collection_id = :collectionId AND classes.duration_id = :id")
    List<Classes> getClassesByDurationId(int collectionId, int id);

    @Query("SELECT * FROM classes WHERE classes.collection_id = :collectionId AND classes.focus_id = :id")
    List<Classes> getClassesByFocusId(int collectionId, int id);
}
