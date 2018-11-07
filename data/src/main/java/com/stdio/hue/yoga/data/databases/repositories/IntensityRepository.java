package com.stdio.hue.yoga.data.databases.repositories;

import com.stdio.hue.yoga.data.models.Intensity;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public interface IntensityRepository {
    void insertIntensity(List<Intensity> intensities);
}
