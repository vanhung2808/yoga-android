package com.stdio.hue.yoga.databases.repositories.impl;

import com.stdio.hue.yoga.data.models.Ability;
import com.stdio.hue.yoga.databases.daos.AbilityDao;
import com.stdio.hue.yoga.databases.repositories.AbilityRepository;

import java.util.List;

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
        for (Ability ability : abilities) {
            abilityDao.insertAbility(ability);
        }
    }
}
