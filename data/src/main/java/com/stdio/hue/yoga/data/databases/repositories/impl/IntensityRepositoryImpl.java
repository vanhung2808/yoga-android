package com.stdio.hue.yoga.data.databases.repositories.impl;

import com.stdio.hue.yoga.data.databases.daos.IntensityDao;
import com.stdio.hue.yoga.data.databases.repositories.IntensityRepository;
import com.stdio.hue.yoga.data.models.Intensity;

import java.util.List;

import io.reactivex.Completable;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class IntensityRepositoryImpl implements IntensityRepository {
    private IntensityDao intensityDao;

    public IntensityRepositoryImpl(IntensityDao intensityDao) {
        this.intensityDao = intensityDao;
    }

    @Override
    public void insertIntensity(List<Intensity> intensities) {
        Completable.fromAction(() -> intensityDao.insertAll(intensities));

    }
}
