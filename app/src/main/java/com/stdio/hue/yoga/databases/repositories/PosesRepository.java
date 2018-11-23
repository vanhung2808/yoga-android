package com.stdio.hue.yoga.databases.repositories;

import com.stdio.hue.yoga.data.models.Poses;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public interface PosesRepository {
    void insertPoses(List<Poses> poses);
}
