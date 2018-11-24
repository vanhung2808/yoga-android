package com.stdio.hue.yoga.databases.repositories;

import com.stdio.hue.yoga.data.models.Duration;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public interface DurationRepository {
    void insertDuration(List<Duration> durations);

    List<Duration> getAllDuration();

}
