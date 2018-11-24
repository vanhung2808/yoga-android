package com.stdio.hue.yoga.databases.repositories.impl;

import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.databases.daos.ClassesDao;
import com.stdio.hue.yoga.databases.repositories.ClassesRepository;

import java.util.List;

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
        for (Classes classesChild : classes) {
            classesDao.insertClasses(classesChild);
        }
    }

    @Override
    public List<Classes> getClassesByDurationId(int collectionId, int id) {
        return classesDao.getClassesByDurationId(collectionId, id);
    }

    @Override
    public List<Classes> getClassesByAbilityId(int collectionId, int id) {
        return classesDao.getClassesByAbilityId(collectionId, id);
    }

    @Override
    public List<Classes> getClassesByFocusId(int collectionId, int id) {
        return classesDao.getClassesByFocusId(collectionId, id);
    }
}
