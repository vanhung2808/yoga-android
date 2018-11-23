package com.stdio.hue.yoga.data.mappers;

import com.stdio.hue.yoga.data.models.Focus;
import com.stdio.hue.yoga.network.GetFocusQuery;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public class FocusMapper extends Mapper<GetFocusQuery.ViewAllFocus, Focus> {
    @Override
    public Focus transform(GetFocusQuery.ViewAllFocus entity) {
        Focus focus = null;
        if (entity != null) {
            focus = new Focus();
            focus.setId(entity.id());
            focus.setName(entity.name());
            focus.setChecked(false);
            focus.setCreatedAt(String.valueOf(entity.created_at()));
            focus.setUpdatedAt(String.valueOf(entity.updated_at()));
        }
        return focus;
    }
}
