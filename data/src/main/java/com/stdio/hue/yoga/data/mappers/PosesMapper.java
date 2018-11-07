package com.stdio.hue.yoga.data.mappers;

import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.network.GetPoseQuery;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public class PosesMapper extends Mapper<GetPoseQuery.Pose, Poses> {
    @Override
    public Poses transform(GetPoseQuery.Pose entity) {
        Poses poses = null;
        if (entity != null) {
            poses = new Poses();
            poses.setId(entity.id());
            poses.setName(entity.name());
            poses.setCreatedAt(entity.created_at());
            poses.setUpdatedAt(entity.updated_at());
            poses.setAbilityId(entity.ability_id());
            poses.setDescription(entity.description());
            poses.setFocusId(entity.focus_id());
            poses.setImage(entity.image());
            poses.setTypeId(entity.type_id());
        }
        return poses;
    }
}
