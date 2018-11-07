package com.stdio.hue.yoga.data.databases.repositories.impl;

import com.stdio.hue.yoga.data.databases.daos.CollectionDao;
import com.stdio.hue.yoga.data.databases.repositories.CollectionRepository;
import com.stdio.hue.yoga.data.models.Collection;

import java.util.List;

import io.reactivex.Completable;

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
        Completable.fromAction(() -> collectionDao.insertAll(collections));

    }
}
