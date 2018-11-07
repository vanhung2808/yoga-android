package com.stdio.hue.yoga.data.mappers;

import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.network.GetClassesQuery;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public class ClassesMapper extends Mapper<GetClassesQuery.Class, Classes> {
    @Override
    public Classes transform(GetClassesQuery.Class entity) {
        Classes classes = null;
        if (entity != null) {
            classes = new Classes();
            classes.setId(entity.id());
            classes.setName(entity.name());
            classes.setCreatedAt(entity.created_at());
            classes.setUpdatedAt(entity.updated_at());
            classes.setImage(entity.image());
            classes.setDescription(entity.description());
            classes.setAbilityId(entity.ability_id());
            classes.setCollectionId(entity.collection_id());
            classes.setDescription(entity.description());
            classes.setDurationId(entity.duration_id());
            classes.setFocusId(entity.focus_id());
            classes.setImage(entity.image());
            classes.setIntensityId(entity.intensity_id());
            classes.setVideoUrl(entity.video_url());
        }
        return classes;
    }
}
