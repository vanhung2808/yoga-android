package com.stdio.hue.yoga.databases.repositories.impl;

import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.databases.daos.PosesDao;
import com.stdio.hue.yoga.databases.repositories.PosesRepository;

import java.util.List;

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
        for (Poses posesChild : poses) {
            posesDao.insertPoses(posesChild);
        }
    }

    @Override
    public List<Poses> getPosesOfClasses(int classesId) {
        return posesDao.getPosesOfClasses(classesId);
    }

    @Override
    public void updatePoses(Poses poses) {
        posesDao.updateFavoritePoses(poses);
    }

    @Override
    public Poses getPosesDetail(int posesId) {
        return posesDao.getPosesDetail(posesId);
    }
}
