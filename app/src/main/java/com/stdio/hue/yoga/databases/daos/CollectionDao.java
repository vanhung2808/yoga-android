package com.stdio.hue.yoga.databases.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.stdio.hue.yoga.data.models.Collection;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
@Dao
public interface CollectionDao {
    @Query("SELECT * FROM collection")
    List<Collection> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertCollection(Collection collections);

    @Delete
    void delete(Collection collection);

    @Update
    void updateAllCollection(Collection... collections);

    @Query("SELECT * FROM collection WHERE collection.id = :collectionId")
    Collection getCollection(int collectionId);

    @Query("SELECT * FROM collection WHERE collection.category_id = :categoryId")
    List<Collection> getCollectionsOfCategory(int categoryId);
}
