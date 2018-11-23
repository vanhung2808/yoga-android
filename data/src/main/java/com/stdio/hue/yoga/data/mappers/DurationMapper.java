package com.stdio.hue.yoga.data.mappers;

import com.stdio.hue.yoga.data.models.Duration;
import com.stdio.hue.yoga.network.GetDurationQuery;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public class DurationMapper extends Mapper<GetDurationQuery.ViewAllDuration, Duration> {
    @Override
    public Duration transform(GetDurationQuery.ViewAllDuration entity) {
        Duration duration = null;
        if (entity != null) {
            duration = new Duration();
            duration.setId(entity.id());
            duration.setName(entity.name());
            duration.setChecked(false);
            duration.setCreatedAt(String.valueOf(entity.created_at()));
            duration.setUpdatedAt(String.valueOf(entity.updated_at()));
        }
        return duration;
    }
}
