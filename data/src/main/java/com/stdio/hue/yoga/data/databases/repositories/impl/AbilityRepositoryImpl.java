package com.stdio.hue.yoga.data.databases.repositories.impl;

import com.stdio.hue.yoga.data.databases.daos.AbilityDao;
import com.stdio.hue.yoga.data.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.data.models.Ability;

import java.util.List;

import io.reactivex.Completable;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class AbilityRepositoryImpl implements AbilityRepository {
    private AbilityDao abilityDao;

    public AbilityRepositoryImpl(AbilityDao abilityDao) {
        this.abilityDao = abilityDao;
    }

    @Override
    public void insertAbility(List<Ability> abilities) {
        Completable.fromAction(() -> abilityDao.insertAll(abilities));
    }
}
