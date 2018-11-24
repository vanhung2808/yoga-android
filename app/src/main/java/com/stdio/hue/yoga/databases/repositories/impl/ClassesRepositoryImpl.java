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
    public List<Classes> getClassesOfCollectionByDurationId(int collectionId, int id) {
        return classesDao.getClassesOfCollectionByDurationId(collectionId, id);
    }

    @Override
    public List<Classes> getClassesOfCollectionByAbilityId(int collectionId, int id) {
        return classesDao.getClassesOfCollectionByAbilityId(collectionId, id);
    }

    @Override
    public List<Classes> getClassesOfCollectionByFocusId(int collectionId, int id) {
        return classesDao.getClassesOfCollectionByFocusId(collectionId, id);
    }

    @Override
    public List<Classes> searchClassesByDurationId(int durationId) {
        return classesDao.searchClassesByDurationId(durationId);
    }

    @Override
    public List<Classes> searchClassesByAbilityId(int abilityId) {
        return classesDao.searchClassesByAbilityId(abilityId);
    }

    @Override
    public List<Classes> searchClassesByFocusId(int focusId) {
        return classesDao.searchClassesByFocusId(focusId);
    }

    @Override
    public List<Classes> searchClassesByIntensityId(int intensityId) {
        return classesDao.searchClassesByIntensityId(intensityId);
    }
}
