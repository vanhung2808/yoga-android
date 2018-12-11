package com.stdio.hue.yoga.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.stdio.hue.yoga.data.models.Poses;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Dao
public interface PosesDao {
    @Query("SELECT * FROM poses")
    List<Poses> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPoses(Poses poses);

    @Delete
    void delete(Poses poses);

    @Update
    void updateAllPoses(List<Poses> poses);

    @Query("SELECT * FROM poses WHERE poses.class_id = :classesId")
    List<Poses> getPosesOfClasses(int classesId);

    @Update
    int updateFavoritePoses(Poses poses);
}
