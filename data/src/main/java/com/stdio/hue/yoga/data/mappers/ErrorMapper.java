package com.stdio.hue.yoga.data.mappers;

import com.stdio.hue.yoga.data.models.base.Error;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public class ErrorMapper extends Mapper<com.apollographql.apollo.api.Error, Error> {
    @Override
    public Error transform(com.apollographql.apollo.api.Error entity) {
        Error error = null;
        if (entity != null) {
            error = new Error();
            error.setMessage(entity.message());
        }
        return error;
    }
}
