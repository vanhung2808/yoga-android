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
    List<Classes> getClassesOfCollectionByAbilityId(int collectionId, int id);

    @Query("SELECT * FROM classes WHERE classes.collection_id = :collectionId AND classes.duration_id = :id")
    List<Classes> getClassesOfCollectionByDurationId(int collectionId, int id);

    @Query("SELECT * FROM classes WHERE classes.collection_id = :collectionId AND classes.focus_id = :id")
    List<Classes> getClassesOfCollectionByFocusId(int collectionId, int id);


    @Query("SELECT * FROM classes WHERE  classes.duration_id = :durationId")
    List<Classes> searchClassesByDurationId(int durationId);

    @Query("SELECT * FROM classes WHERE  classes.ability_id = :abilityId")
    List<Classes> searchClassesByAbilityId(int abilityId);

    @Query("SELECT * FROM classes WHERE  classes.focus_id = :focusId")
    List<Classes> searchClassesByFocusId(int focusId);

    @Query("SELECT * FROM classes WHERE  classes.intensity_id = :intensityId")
    List<Classes> searchClassesByIntensityId(int intensityId);
}
