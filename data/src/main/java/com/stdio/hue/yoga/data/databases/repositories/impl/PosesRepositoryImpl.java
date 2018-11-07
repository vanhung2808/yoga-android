package com.stdio.hue.yoga.data.databases.repositories.impl;

import com.stdio.hue.yoga.data.databases.daos.PosesDao;
import com.stdio.hue.yoga.data.databases.repositories.PosesRepository;
import com.stdio.hue.yoga.data.models.Poses;

import java.util.List;

import io.reactivex.Completable;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class PosesRepositoryImpl implements PosesRepository {
    private PosesDao posesDao;

    public PosesRepositoryImpl(PosesDao posesDao) {
        this.posesDao = posesDao;
    }

    @Override
    public void insertPoses(List<Poses> poses) {
        Completable.fromAction(() -> posesDao.insertAll(poses));
    }
}
