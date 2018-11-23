package com.stdio.hue.yoga.data.mappers;

import com.stdio.hue.yoga.data.models.Ability;
import com.stdio.hue.yoga.network.GetAbilityQuery;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public class AbilityMapper extends Mapper<GetAbilityQuery.ViewAllAbility, Ability> {
    @Override
    public Ability transform(GetAbilityQuery.ViewAllAbility entity) {
        Ability ability = null;
        if (entity != null) {
            ability = new Ability();
            ability.setId(entity.id());
            ability.setName(entity.name());
            ability.setChecked(false);
            ability.setCreatedAt(String.valueOf(entity.created_at()));
            ability.setUpdatedAt(String.valueOf(entity.updated_at()));
        }
        return ability;
    }
}
