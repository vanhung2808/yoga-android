package com.stdio.hue.yoga.databases.repositories.impl;

import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.databases.daos.CollectionDao;
import com.stdio.hue.yoga.databases.repositories.CollectionRepository;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class CollectionRepositoryImpl implements CollectionRepository {
    private CollectionDao collectionDao;

    public CollectionRepositoryImpl(CollectionDao collectionDao) {
        this.collectionDao = collectionDao;
    }

    @Override
    public void insertCollection(List<Collection> collections) {
        for (Collection collection : collections) {
            collectionDao.insertCollection(collection);
        }
    }
}
