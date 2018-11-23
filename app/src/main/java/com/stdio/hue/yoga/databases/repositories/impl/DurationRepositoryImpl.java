package com.stdio.hue.yoga.databases.repositories.impl;

import com.stdio.hue.yoga.data.models.Duration;
import com.stdio.hue.yoga.databases.daos.DurationDao;
import com.stdio.hue.yoga.databases.repositories.DurationRepository;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class DurationRepositoryImpl implements DurationRepository {
    private DurationDao durationDao;

    public DurationRepositoryImpl(DurationDao durationDao) {
        this.durationDao = durationDao;
    }

    @Override
    public void insertDuration(List<Duration> durations) {
        for (Duration duration : durations) {
            durationDao.insertDuration(duration);
        }
    }
}
