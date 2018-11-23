package com.stdio.hue.yoga.databases.repositories;

import com.stdio.hue.yoga.data.models.Classes;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public interface ClassesRepository {
    void insertClasses(List<Classes> classes);
}
