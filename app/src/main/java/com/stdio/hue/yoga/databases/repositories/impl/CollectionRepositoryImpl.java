package com.stdio.hue.yoga.databases.repositories.impl;

import android.util.Log;

import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.databases.daos.ClassesDao;
import com.stdio.hue.yoga.databases.daos.CollectionDao;
import com.stdio.hue.yoga.databases.repositories.CollectionRepository;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class CollectionRepositoryImpl implements CollectionRepository {
    private CollectionDao collectionDao;
    private ClassesDao classesDao;

    public CollectionRepositoryImpl(CollectionDao collectionDao, ClassesDao classesDao) {
        this.collectionDao = collectionDao;
        this.classesDao = classesDao;
    }

    @Override
    public void insertCollection(List<Collection> collections) {
        for (Collection collection : collections) {
            collectionDao.insertCollection(collection);
        }
    }

    @Override
    public List<Collection> getCollectionsOfCategory(int categoryId) {
        List<Collection> collections = collectionDao.getCollectionsOfCategory(categoryId);
        Log.e("PHUC", categoryId + " - getCollectionsOfCategory size = " + collections.size());
        for (Collection collection : collections) {
            collection.setTotalClasses(classesDao.countClassesOfCollection(collection.getId()));
        }
        return collections;
    }
}
