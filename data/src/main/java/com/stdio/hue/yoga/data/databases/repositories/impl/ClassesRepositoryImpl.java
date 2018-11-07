package com.stdio.hue.yoga.data.databases.repositories.impl;

import com.stdio.hue.yoga.data.databases.daos.ClassesDao;
import com.stdio.hue.yoga.data.databases.repositories.ClassesRepository;
import com.stdio.hue.yoga.data.models.Classes;

import java.util.List;

import io.reactivex.Completable;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class ClassesRepositoryImpl implements ClassesRepository {
    private ClassesDao classesDao;

    public ClassesRepositoryImpl(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }

    @Override
    public void insertClasses(List<Classes> classes) {
        Completable.fromAction(() -> classesDao.insertAll(classes));

    }
}
