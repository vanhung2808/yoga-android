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
            poses.setCreatedAt(String.valueOf(entity.created_at()));
            poses.setUpdatedAt(String.valueOf(entity.updated_at()));
            poses.setAbilityId(String.valueOf(entity.ability_id()));
            poses.setDescription(entity.description());
            poses.setFocusId(String.valueOf(entity.focus_id()));
            poses.setImage(entity.image());
            poses.setTypeId(String.valueOf(entity.type_id()));
            poses.setClassId(String.valueOf(entity.class_id()));
            poses.setDuration(String.valueOf(entity.duration()));
            poses.setDurationId(String.valueOf(entity.duration_id()));
        }
        return poses;
    }
}
