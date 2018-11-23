package com.stdio.hue.yoga.databases.repositories.impl;

import com.stdio.hue.yoga.data.models.Intensity;
import com.stdio.hue.yoga.databases.daos.IntensityDao;
import com.stdio.hue.yoga.databases.repositories.IntensityRepository;

import java.util.List;

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
        for (Intensity intensity : intensities) {
            intensityDao.insertIntensity(intensity);
        }
    }
}
