package com.stdio.hue.yoga.data.mappers;

import com.stdio.hue.yoga.data.models.Intensity;
import com.stdio.hue.yoga.network.GetIntensityQuery;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public class IntensityMapper extends Mapper<GetIntensityQuery.ViewAllIntensity, Intensity> {
    @Override
    public Intensity transform(GetIntensityQuery.ViewAllIntensity entity) {
        Intensity intensity = null;
        if (entity != null) {
            intensity = new Intensity();
            intensity.setId(entity.id());
            intensity.setName(entity.name());
            intensity.setChecked(false);
            intensity.setCreatedAt(entity.created_at());
            intensity.setUpdatedAt(entity.updated_at());
        }
        return intensity;
    }
}