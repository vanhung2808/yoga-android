package com.stdio.hue.yoga.databases.repositories;

import com.stdio.hue.yoga.data.models.Classes;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public interface ClassesRepository {
    void insertClasses(List<Classes> classes);

    List<Classes> getClassesOfCollectionByDurationId(int collectionId, int id);

    List<Classes> getClassesOfCollectionByAbilityId(int collectionId, int id);

    List<Classes> getClassesOfCollectionByFocusId(int collectionId, int id);

    List<Classes> searchClassesByDurationId(int durationId);

    List<Classes> searchClassesByAbilityId(int abilityId);

    List<Classes> searchClassesByFocusId(int focusId);

    List<Classes> searchClassesByIntensityId(int intensityId);
}
