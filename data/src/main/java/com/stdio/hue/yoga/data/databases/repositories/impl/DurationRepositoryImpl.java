package com.stdio.hue.yoga.data.databases.repositories.impl;

import com.stdio.hue.yoga.data.databases.daos.DurationDao;
import com.stdio.hue.yoga.data.databases.repositories.DurationRepository;
import com.stdio.hue.yoga.data.models.Duration;

import java.util.List;

import io.reactivex.Completable;

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
        Completable.fromAction(() -> durationDao.insertAll(durations));

    }
}
